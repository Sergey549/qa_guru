import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class AlfaBankTests {

    private String alfaMain = "https://alfabank.ru/";
    private int actualWidgetsQuantity = 5;
    private SelenideElement DEPOSITS = $(By.linkText("Вклады"));
    private SelenideElement ARCHIVE_ACCOUNT_AND_DEPOSITS_BUTTON = $(".\\_3DsVR");
    private SelenideElement DEPOSIT_WIDGET = $x("//span[text()='Депозиты']");
    private SelenideElement WIDGET = $(By.linkText("Депозиты"));
    private ElementsCollection WIDGETS = $$x("//div[@data-widget-name='CatalogCard']");
    private String savingsServicesText;
    private SelenideElement savingsServices = WIDGET.sibling(0);


    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1024x768";
        Configuration.browser = "chrome";
        //Configuration.headless = true;
        open(alfaMain);
    }

    @Test
    void depositsWidgetsQuantity() {
        DEPOSITS.click();
        WIDGET.click();
        ARCHIVE_ACCOUNT_AND_DEPOSITS_BUTTON.click();
        DEPOSIT_WIDGET.click();
        int elements = WIDGETS.size();
        System.out.println("Количество виджетов: " + elements);
        assertEquals( actualWidgetsQuantity, elements);
    }

    @Test
    void savingsServicesClick(){
        DEPOSITS.click();
        savingsServices.click();
        savingsServicesText = savingsServices.text();
        System.out.println("Название кнопки: " + savingsServicesText);
        assertEquals("Сервисы для накоплений", savingsServicesText );
    }

    @AfterEach
    void tearDown(){
        Selenide.closeWebDriver();
    }
}
