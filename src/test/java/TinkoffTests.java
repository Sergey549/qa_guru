import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class TinkoffTests {

    private SelenideElement textElement = $x("//div[@class='Pie__container_g1cseG']/div[contains(@class,'13')]");
    private SelenideElement summa = $x("//label[text()='Сумма вклада']/parent ::div//div/input");
    private SelenideElement deposits = $(By.linkText("Вклады"));
    private SelenideElement pie = $(".Pie__part_c1cseG:nth-child(4)");
    private SelenideElement depositSumSlider = $(".Thumb__thumb_a3KtIl");
    private String tinkoffMain = "https://www.tinkoff.ru/";

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1400x3000";
        open(tinkoffMain);
    }

    @Test
    void pieHover(){
        deposits.click();
        String before = textElement.text().replace("\n", " ");
        System.out.println("Текст до наведения курсора: " + before);
        pie.hover();
        String after = textElement.text();
        System.out.println("Текст после наведения курсора: " + after);
        Assert.assertEquals("НАЧИСЛЕНИЯ %", after);
    }

    @Test
    void depositSumSliderMotion(){
        deposits.click();
        String summaBeforeDrug = summa.getAttribute("value");
        System.out.println("Сумма до перемещения  слайдера суммы вклада: " + summaBeforeDrug);
        actions().dragAndDropBy(depositSumSlider, 50, 0).perform();
        String summaAfterDrug = summa.getAttribute("value");
        System.out.println("Сумма после перемещения  слайдера суммы вклада: " + summaAfterDrug);
        Assert.assertEquals("5 655 000", summaAfterDrug);
    }

    @AfterEach
    void tearDown(){
        Selenide.closeWebDriver();
    }

}
