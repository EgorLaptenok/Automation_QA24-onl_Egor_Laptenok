package lesson4;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private PaymentPage paymentPage;
    private FinishPage finishPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        paymentPage = new PaymentPage();
        finishPage = new FinishPage();
        loginPage.open("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void SuccessfulLoginTest() {
        loginPage.enterUserName(loginPage.getUserName().get(0));
        loginPage.enterPassword(loginPage.getPassword().get(0));
        loginPage.successfulLoginPage();
        loginPage.clickLogin();
        homePage.verifyPage();
    }

    @Test(priority = 2)
    public void blockedUserTest() {
        loginPage.open("https://www.saucedemo.com/");
        loginPage.enterUserName(loginPage.getUserName().get(1));
        loginPage.enterPassword(loginPage.getPassword().get(0));
        loginPage.successfulLoginPage();
        loginPage.clickLogin();
        loginPage.errorMassageLocked();

    }

    @Test(priority = 3)
    public void UnknownUserTest() {
        loginPage.open("https://www.saucedemo.com/");
        loginPage.enterPassword(loginPage.getPassword().get(0));
        loginPage.successfulLoginPage();
        loginPage.clickLogin();
        loginPage.errorRequired();
    }

    @Test(priority = 4)
    public void addToCardTest() {
        loginPage.open("https://www.saucedemo.com/");
        loginPage.enterUserName(loginPage.getUserName().get(0));
        loginPage.enterPassword(loginPage.getPassword().get(0));
        loginPage.successfulLoginPage();
        loginPage.clickLogin();
        homePage.verifyPage();
        homePage.clickAddToCart(0);
        homePage.successfulAddToCard();
        homePage.clickCart();
        cartPage.verifyPage();
    }

    @Test(priority = 5)
    public void removeProductTest() {
        cartPage.removeProduct();
    }

    @Test(priority = 6)
    public void paymentTest() {
        loginPage.open("https://www.saucedemo.com/inventory.html");
        homePage.verifyPage();
        homePage.clickAddToCart(0);
        homePage.successfulAddToCard();
        homePage.clickCart();
        cartPage.verifyPage();
        cartPage.clickCheckout();
        paymentPage.verifyPage();
        paymentPage.enterName("Sasha");
        paymentPage.enterSurname("Smith");
        paymentPage.enterZipCod("124568");
        paymentPage.clickButtonContinue();
        cartPage.successfulPayment();
        cartPage.clickFinish();
        finishPage.verifyPage();
    }
}
