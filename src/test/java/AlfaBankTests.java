import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    private String alfaMain = "https://alfabank.ru/";
    private int actualWidgetsQuantity = 5;
    private SelenideElement deposits = $(By.linkText("Вклады"));
    private SelenideElement archiveAccountsAndDepositsButton = $(".\\_3DsVR");
    private SelenideElement depositWidget = $x("//span[text()='Депозиты']");
    private SelenideElement widget = $(By.linkText("Депозиты"));
    private ElementsCollection widgets = $$x("//div[@data-widget-name='CatalogCard']");
    private String savingsServicesText;
    private SelenideElement savingsServices = widget.sibling(0);


    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1024x768";
        Configuration.browser = "chrome";
        //Configuration.headless = true;
        open(alfaMain);
    }

    @Test
    void depositsWidgetsQuantity() {
        deposits.click();
        widget.click();
        archiveAccountsAndDepositsButton.click();
        depositWidget.click();
        int elements = widgets.size();
        System.out.println(elements);
        Assert.assertEquals( actualWidgetsQuantity, elements);
    }

    @Test
    void savingsServicesClick(){
        deposits.click();
        savingsServices.click();
        savingsServicesText = savingsServices.text();
        System.out.println(savingsServicesText);
        Assert.assertEquals("Сервисы для накоплений", savingsServicesText );
    }

    @AfterEach
    void tearDown(){
        Selenide.closeWebDriver();
    }
}
