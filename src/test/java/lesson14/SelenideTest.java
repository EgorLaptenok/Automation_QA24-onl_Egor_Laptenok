package lesson14;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideTest {
    @BeforeTest
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        open("https://google.com");
    }
    @Test
    public void firstTest(){
        $("[name='q']").setValue("hello").pressEnter();
        sleep(5000);
    }
}
