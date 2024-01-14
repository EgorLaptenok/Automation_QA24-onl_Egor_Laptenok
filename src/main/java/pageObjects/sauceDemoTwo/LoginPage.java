package pageObjects.sauceDemoTwo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.getProperties;

public class LoginPage extends BasePage {
    private final By header = By.className("login_logo");
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorButton = By.xpath("//button[@class='error-button']");
    private final By errorText = By.xpath("//h3[@data-test='error']");

    public void open(String url) {
        navigateTo(url);
    }

    public void open() {
        navigateTo(getProperties().getProperty("url"));
    }

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong header url");
    }

    public void enterLogin(String login) {
        sendKeys(usernameField, login);
    }

    public void enterLogin() {
        sendKeys(usernameField, getProperties().getProperty("username"));
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void enterPassword() {
        sendKeys(passwordField, getProperties().getProperty("user-password"));
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void clickError() {
        click(errorButton);
    }

    public boolean errorMassage() {
        boolean error = !driver.findElements(errorButton).isEmpty();
        return !error;
    }

    public void errorText() {
        String actualText = driver.findElement(errorText).getText();
        Assert.assertTrue(actualText.equals("Epic sadface: Sorry, this user has been locked out.") || actualText.equals("Epic sadface: Username is required") || actualText.equals("Epic sadface: Username and password do not match any user in this service"), "Wrong massage");
    }
}
