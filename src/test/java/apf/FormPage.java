package apf;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FormPage{

    protected FormPage fillTestFormWithRequiredFields() {
        fillFirstName("Test");
        fillLastName("User");
        setGender(1);
        fillUserPhone("89001234567");
        return this;
    }

    protected SubmitPage submitForm() {
        $("#submit").click();
        return new SubmitPage();
    }

    private FormPage setGender(int i) {
        $x("//label[contains(@for,'" + i + "')]").click();
        return this;
    }

    private FormPage fillUserPhone(String userPhone) {
        $("#userNumber").click();
        $("#userNumber").clear();
        $("#userNumber").sendKeys(userPhone);
        return this;
    }

    private FormPage fillLastName(String LastName) {
        $("#lastName").click();
        $("#lastName").clear();
        $("#lastName").sendKeys(LastName);
        return this;
    }

    private FormPage fillFirstName(String firstName) {
        $("#firstName").click();
        $("#firstName").clear();
        $("#firstName").sendKeys(firstName);
        return this;
    }

    protected FormPage fillAllFields() {
        fillTestFormWithRequiredFields();
        fillOtherFields();
        return this;
    }

    private FormPage fillOtherFields() {
        fillEmail("test_user@test.com");
        return this;
    }

    private FormPage fillEmail(String userEmail) {
        $("#userEmail").click();
        $("#userEmail").clear();
        $("#userEmail").sendKeys(userEmail);
        return this;
    }
}
