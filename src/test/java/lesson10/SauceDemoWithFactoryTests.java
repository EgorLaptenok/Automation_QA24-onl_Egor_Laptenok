package lesson10;

import org.testng.annotations.*;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class SauceDemoWithFactoryTests extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    String usernamePass;
    String passwordPass;

    @Parameters({"url", "usernamePass", "passwordPass"})
    @BeforeTest
    public void precondition(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("standard_user") String usernamePass,
                             @Optional("secret_sauce") String passwordPass) {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        loginPage.open(url);
        this.usernamePass = usernamePass;
        this.passwordPass = passwordPass;
    }

    @Test(dataProvider = "loginData", priority = 1)
    public void LoginPageTestsPositiveOrNegative(String username) {
        loginPage
                .waitUntilPageLoaded()
                .verifyPage()
                .enterLogin(username)
                .enterPassword(passwordPass)
                .clickLogin();
        if (loginPage.errorMassage()) {
            productPage
                    .verifyPage()
                    .clickBurger()
                    .clickLogOut();
        } else {
            loginPage
                    .errorText()
                    .clickError();
        }

    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user"},
                {"locked_out_user"},
                {" "},
                {"performance_glitch_user"}
        };
    }

}
