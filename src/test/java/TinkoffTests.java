import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class TinkoffTests {

    private SelenideElement TEXT_ELEMENT = $x("//div[@class='Pie__container_g1cseG']/div[contains(@class,'13')]");
    private SelenideElement SUMMA = $x("//label[text()='Сумма вклада']/parent ::div//div/input");
    private SelenideElement DEPOSITS = $(By.linkText("Вклады"));
    private SelenideElement PIE = $(".Pie__part_c1cseG:nth-child(4)");
    private SelenideElement DEPOSIT_SUM_SLIDER = $(".Thumb__thumb_a3KtIl");
    private String tinkoffMain = "https://www.tinkoff.ru/";

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1024x768";
        Configuration.browser = "chrome";
        //Configuration.headless = true;
        open(tinkoffMain);
    }

    @Test
    void pieHover(){
        DEPOSITS.click();
        String before = TEXT_ELEMENT.text().replace("\n", " ");
        System.out.println("Текст до наведения курсора: " + before);
        PIE.hover();
        String after = TEXT_ELEMENT.text();
        System.out.println("Текст после наведения курсора: " + after);
        assertEquals("Тексты не совпадают","НАЧИСЛЕНИЯ %", after);
    }

    @Test
    void depositSumSliderMotion(){
        DEPOSITS.click();
        String summaBeforeDrug = SUMMA.getAttribute("value");
        System.out.println("Сумма до перемещения слайдера суммы вклада: " + summaBeforeDrug);
        actions().dragAndDropBy(DEPOSIT_SUM_SLIDER, 50, 0).perform();
        String summaAfterDrug = SUMMA.getAttribute("value");
        System.out.println("Сумма после перемещения слайдера суммы вклада: " + summaAfterDrug);
        assertEquals("Суммы не совпадают","5 655 000", summaAfterDrug);
    }

    @AfterEach
    void tearDown(){
        Selenide.closeWebDriver();
    }

}
