package pageFactory.saucedemo;

import entities.saucedemo.User;
import entities.saucedemo.UserBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.getProperties;

public class LoginPage extends BasePage implements Page<LoginPage> {

    @FindBy(how = How.CLASS_NAME, using = "login_logo")
    WebElement header;
    @FindBy(how = How.ID, using = "user-name")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginButton;
    private final By errorButton = By.xpath("//button[@class='error-button']");
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorText;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public LoginPage open(String url) {
        navigateTo(url);
        return this;
    }

    public LoginPage open() {
        navigateTo(getProperties().getProperty("url"));
        return this;
    }

    public LoginPage verifyPage() {
        Assert.assertEquals(header.getText(), "Swag Labs", "Wrong header name");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong header url");
        return this;
    }

    public LoginPage enterLogin(String login) {
        sendKeys(usernameField, login);
        return this;
    }

    public LoginPage enterLogin() {
        sendKeys(usernameField, getProperties().getProperty("username"));
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordField, password);
        return this;
    }

    public LoginPage enterPassword() {
        sendKeys(passwordField, getProperties().getProperty("user-password"));
        return this;
    }

    public LoginPage clickLogin() {
        click(loginButton);
        return this;
    }

    public LoginPage clickError() {
        click(errorButton);
        return this;
    }
    public LoginPage login(User user){
        return enterLogin(user.getUsername()).enterPassword(user.getPassword());
    }
    public LoginPage login(UserBuilder userBuilder){
        return enterLogin(userBuilder.getUsername()).enterPassword(userBuilder.getPassword());
    }


    public boolean errorMassage() {
        boolean error = !driver.findElements(errorButton).isEmpty();
        return !error;
    }

    public LoginPage errorText() {
        String actualText = errorText.getText();
        Assert.assertTrue(actualText.equals("Epic sadface: Sorry, this user has been locked out.")
                || actualText.equals("Epic sadface: Username is required")
                || actualText.equals("Epic sadface: Username and password do not match any user in this service")
                , "Wrong massage");
        return this;
    }
    @Override
    public LoginPage waitUntilPageLoaded(){
        Arrays.asList(usernameField,passwordField,loginButton).forEach(el->wait.until(ExpectedConditions.visibilityOf(el)));
        return this;
    }
}
