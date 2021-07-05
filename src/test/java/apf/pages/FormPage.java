package apf.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FormPage{

    private SelenideElement userNumber = $("#userNumber");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement userEmail = $("#userEmail");
    private SelenideElement firstName = $("#firstName");

    public FormPage fillTestFormWithRequiredFields() {
        fillFirstName("Test");
        fillLastName("User");
        setGender(1);
        fillUserPhone("89001234567");
        return this;
    }

    public SubmitPage submitForm() {
        $("#submit").click();
        return new SubmitPage();
    }

    private FormPage setGender(int i) {
        $x("//label[contains(@for,'" + i + "')]").click();
        return this;
    }

    private FormPage fillUserPhone(String userPhone) {
        userNumber.click();
        userNumber.clear();
        userNumber.sendKeys(userPhone);
        return this;
    }

    private FormPage fillLastName(String lastUserName) {
        lastName.click();
        lastName.clear();
        lastName.sendKeys(lastUserName);
        return this;
    }

    private FormPage fillFirstName(String firstUserName) {
        firstName.click();
        firstName.clear();
        firstName.sendKeys(firstUserName);
        return this;
    }

    public FormPage fillAllFields() {
        fillTestFormWithRequiredFields();
        fillOtherFields();
        return this;
    }

    private FormPage fillOtherFields() {
        fillEmail("test_user@test.com");
        return this;
    }

    private FormPage fillEmail(String email) {
        userEmail.click();
        userEmail.clear();
        userEmail.sendKeys(email);
        return this;
    }
}
