package lesson10;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class ProductPageFactoryTest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    int count = 0;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        loginPage.open();
    }

    @Test(invocationCount = 6, priority = 3)
    public void addProductCountTest() {
        if (count == 0) {
            loginPage
                    .enterLogin()
                    .enterPassword()
                    .clickLogin();

        }
        productPage
                .clickAddToCard(count++)
                .verifyPage();
    }
}
