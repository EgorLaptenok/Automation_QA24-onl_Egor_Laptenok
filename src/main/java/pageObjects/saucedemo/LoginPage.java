package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

public class LoginPage extends BasePage {
    private final By header = By.className("login_logo");
    private final By username = By.id("user-name");
    private final By password = By.name("password");
    private final By login = By.cssSelector("input[value='Login']");
    private final By loginCredentials = By.id("login_credentials");
    private final By loginPassword = By.className("login_password");
    private final By error = By.xpath("//h3[@data-test='error']");

    public void open(String url) {
        getDriver().get(url);
    }

    public void successfulLoginPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name");
        Arrays.asList(username, login, password).forEach(el -> Assert.assertTrue(getDriver().findElement(el).isDisplayed(), "Element not displayed :: " + el));
    }

    public void enterUserName(String username) {
        sendKeys(this.username, username);
    }

    public void enterPassword(String password) {
        sendKeys(this.password, password);
    }

    public List<String> getUserName() {
        return Arrays.stream(getDriver().findElement(loginCredentials).getText().split("\n"))
                .filter(val -> !val.contains("Accepted usernames are:"))
                .collect(Collectors.toList());
    }

    public List<String> getPassword() {
        return Arrays.stream(getDriver().findElement(loginPassword).getText().split("\n"))
                .filter(val -> !val.contains("Password for all users:"))
                .collect(Collectors.toList());
    }

    public void clickLogin() {
        click(login);
    }

    public void errorMassageLocked() {
        Assert.assertEquals(getDriver().findElement(error).getText(), "Epic sadface: Sorry, this user has been locked out.", "Wrong error massage");
    }

    public void errorRequired() {
        Assert.assertEquals(getDriver().findElement(error).getText(), "Epic sadface: Username is required", "Wrong error massage");
    }
}
