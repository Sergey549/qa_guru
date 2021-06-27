import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyFirstTest {

    @Test
    void openTest(){
        open("https://demoqa.com/automation-practice-form");
        String a = $("#firstName").getAttribute("placeholder");
        System.out.println(a);
//        assert (a.equals("First Name or"));
        Assert.assertEquals(a, "First Name or");
    }
}
