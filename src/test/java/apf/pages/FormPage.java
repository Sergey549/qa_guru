package apf.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FormPage{

    private SelenideElement USER_NUMBER = $("#userNumber");
    private SelenideElement LAST_NAME = $("#lastName");
    private SelenideElement USER_EMAIL = $("#userEmail");
    private SelenideElement FIRST_NAME = $("#firstName");
    private SelenideElement SUBMIT_BUTTON = $("#submit");
    private int genderId = 1;
    private SelenideElement GENDER_RADIO = $x("//label[contains(@for,'" + genderId + "')]");
    private String firstName = "Test";
    private String lastName = "User";
    private String phone = "89001234567";

    public FormPage fillTestFormWithRequiredFields() {
        fillFirstName(firstName);
        fillLastName(lastName);
        setGender(genderId);
        fillUserPhone(phone);
        return this;
    }

    public SubmitPage submitForm() {
        SUBMIT_BUTTON.click();
        return new SubmitPage();
    }

    private FormPage setGender(int genderId) {
        GENDER_RADIO.click();
        return this;
    }

    private FormPage fillUserPhone(String userPhone) {
        USER_NUMBER.click();
        USER_NUMBER.clear();
        USER_NUMBER.sendKeys(userPhone);
        return this;
    }

    private FormPage fillLastName(String lastUserName) {
        LAST_NAME.click();
        LAST_NAME.clear();
        LAST_NAME.sendKeys(lastUserName);
        return this;
    }

    private FormPage fillFirstName(String firstUserName) {
        FIRST_NAME.click();
        FIRST_NAME.clear();
        FIRST_NAME.sendKeys(firstUserName);
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
        USER_EMAIL.click();
        USER_EMAIL.clear();
        USER_EMAIL.sendKeys(email);
        return this;
    }
}
