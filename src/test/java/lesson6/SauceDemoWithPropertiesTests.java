package lesson6;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.sauceDemoTwo.CartPage;
import pageObjects.sauceDemoTwo.LoginPage;
import pageObjects.sauceDemoTwo.ProductsPage;

public class SauceDemoWithPropertiesTests extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        loginPage.open();
    }

    @Test(priority = 1)
    public void LoginPageTestPositive() {
        loginPage.verifyPage();
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickLogin();
        productsPage.verifyPage();
        productsPage.clickBurger();
        productsPage.clickLogOut();
    }

    @Test(priority = 2)
    public void addProductToCartTests() {
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickLogin();
        productsPage.verifyPage();
        productsPage.clickItem("Sauce Labs Backpack");
        productsPage.clickAddToCart();
        productsPage.clickCart();
        cartPage.verifyPage();
        cartPage.clickRemove();
        cartPage.successfulRemove();
        productsPage.clickBurger();
        productsPage.clickLogOut();
        loginPage.verifyPage();
    }

    @Test(priority = 3)
    public void addProductCountTest() {
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickLogin();
        productsPage.verifyPage();
        productsPage.clickItemCount(2);
        productsPage.clickAddToCart();
        productsPage.clickCart();
        cartPage.verifyPage();
        cartPage.clickRemove();
        cartPage.successfulRemove();
        productsPage.clickBurger();
        productsPage.clickAllItem();
    }

}
