package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class PaymentPage extends BasePage {
    private final By checkout = By.className("title");
    private final By checkoutInfo = By.className("checkout_info");
    private final By inputName = By.xpath("//input[@placeholder='First Name']");
    private final By inputSurname = By.xpath("//input[@placeholder='Last Name']");
    private final By inputZipCode = By.xpath("//input[@placeholder='Zip/Postal Code']");
    private final By buttonContinue = By.xpath("//input[@type='submit']");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(checkout).getText(), "Checkout: Your Information", "Wrong information name");
        Assert.assertTrue(getDriver().findElement(checkoutInfo).isDisplayed(), "Info is Empty");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "Wrong header url");
    }

    public void enterName(String name) {
        sendKeys(this.inputName, name);
    }

    public void enterSurname(String surname) {
        sendKeys(this.inputSurname, surname);
    }

    public void enterZipCod(String zipCod) {
        sendKeys(this.inputZipCode, zipCod);
    }

    public void clickButtonContinue() {
        click(buttonContinue);
    }
}
