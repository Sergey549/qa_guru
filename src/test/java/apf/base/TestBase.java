package apf.base;

import apf.pages.FormPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public FormPage formPage = new FormPage();

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1024x768";
        Configuration.browser = "chrome";
        //Configuration.headless = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
