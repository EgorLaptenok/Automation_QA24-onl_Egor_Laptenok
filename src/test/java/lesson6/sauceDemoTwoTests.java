package lesson6;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.sauceDemoTwo.CartPage;
import pageObjects.sauceDemoTwo.LoginPage;
import pageObjects.sauceDemoTwo.ProductsPage;

public class sauceDemoTwoTests extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    int count = 0;
    String usernamePass;
    String passwordPass;
    @Parameters({"url","usernamePass","passwordPass"})
    @BeforeTest
    public void precondition(String url,String usernamePass,String passwordPass) {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        loginPage.open(url);
        this.usernamePass = usernamePass;
        this.passwordPass = passwordPass;
    }

    @Test(dataProvider = "loginData", priority = 1)
    public void LoginPageTestsPositiveOrNegative(String username, String password) {
        loginPage.verifyPage();
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if (loginPage.errorMassage()) {
            productsPage.verifyPage();
            productsPage.clickBurger();
            productsPage.clickLogOut();
        } else {
            loginPage.errorText();
            loginPage.clickError();
        }

    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {" ", "secret_sauce"},
                {"performance_glitch_user", "password"}
        };
    }

    @Test(dataProvider = "addProduct", priority = 2)
    public void addProductToCartTests(String product) {
        loginPage.enterLogin(usernamePass);
        loginPage.enterPassword(passwordPass);
        loginPage.clickLogin();
        productsPage.verifyPage();
        productsPage.clickItem(product);
        productsPage.clickAddToCart();
        productsPage.clickCart();
        cartPage.verifyPage();
        cartPage.clickRemove();
        cartPage.successfulRemove();
        productsPage.clickBurger();
        productsPage.clickLogOut();
        loginPage.verifyPage();
    }

    @DataProvider(name = "addProduct")
    public Object[][] addProduct() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }
    @Test(invocationCount = 6,priority = 3)
    public void addProductCountTest(){
        if(count==0) {
            loginPage.enterLogin("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLogin();
        }
        productsPage.verifyPage();
        productsPage.clickItemCount(count++);
        productsPage.clickAddToCart();
        productsPage.clickCart();
        cartPage.verifyPage();
        cartPage.clickRemove();
        cartPage.successfulRemove();
        productsPage.clickBurger();
        productsPage.clickAllItem();
    }
}
