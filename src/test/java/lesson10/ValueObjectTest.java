package lesson10;

import entities.saucedemo.User;
import entities.saucedemo.UserBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class ValueObjectTest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        loginPage.open();
        productPage = new ProductPage();
    }

    @Test(priority = 1)
    public void loginTest() {
        loginPage
                .waitUntilPageLoaded()
                .login(new User() {{
                    setUsername("standard_user");
                    setPassword("secret_sauce");
                }})
                .clickLogin();
        productPage.logOut();
    }

    @Test(priority = 2, dataProvider = "get user")
    public void loginTestTwo(UserBuilder user) {
        loginPage.waitUntilPageLoaded()
                .login(user)
                .clickLogin();
        productPage.logOut();
    }

    @DataProvider(name = "get user")
    public Object[][] getUserData() {
        return new Object[][]{
                {new UserBuilder.Builder()
                        .withUsername("standard_user")
                        .withPassword("secret_sauce")
                        .build()},
                {new UserBuilder.Builder()
                        .withUsername("problem_user")
                        .withPassword("secret_sauce")
                        .build()},
                {new UserBuilder.Builder()
                        .withUsername("performance_glitch_user")
                        .withPassword("secret_sauce")
                        .build()},
        };
    }
}
