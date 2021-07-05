package apf;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeForm extends TestBase{

    public FormPage formPage = new FormPage();

    @Test
    void requiredFieldsFilling() {
        formPage.fillTestFormWithRequiredFields();
        formPage.submitForm();
        $(".modal-content").shouldBe(visible);
    }

    @Test
    void fillingAllFields() {
        formPage.fillAllFields();
        formPage.submitForm();
        $(".modal-content").shouldBe(visible);
    }

}
