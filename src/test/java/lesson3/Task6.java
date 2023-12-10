package lesson3;

import driver.SimpleWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.SimpleWebDriver.getWebDriver;

public class Task6 {
    SimpleWebDriver simpleWebDriver = new SimpleWebDriver();

    @BeforeTest
    public void setUp() {
        getWebDriver().get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void testAuthorization() {
        authorization();
        String logo = getWebDriver().findElement(By.xpath("//div [@class = 'app_logo']")).getText();
        Assert.assertEquals(logo, "Swag Labs");
    }

    @Test(priority = 2)//Search for locators using the following criteria
    public void findLogo() {
        // linktext
        WebElement slb = getWebDriver().findElement(By.linkText("Sauce Labs Backpack"));
        Assert.assertTrue(slb.isDisplayed());

        // partiallinktext
        WebElement twitter = getWebDriver().findElement(By.partialLinkText("Twitter"));
        Assert.assertTrue(twitter.isDisplayed());
        WebElement product = getWebDriver().findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertTrue(product.isDisplayed());

        // Поиск по частичному совпадению атрибута
        WebElement image = getWebDriver().findElement(By.xpath("//img[contains(@src,'backpack')]"));
        Assert.assertTrue(image.isDisplayed());

        // Поиск по частичному совпадению текста
        WebElement footer = getWebDriver().findElement(By.xpath("//div[contains(text(),'Sauce Labs')]"));
        Assert.assertTrue(footer.isDisplayed());

        // ancestor
        WebElement container = getWebDriver().findElement(By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item']"));
        Assert.assertTrue(container.isDisplayed());

        // [attribute~=value]
        WebElement inventoryItem = getWebDriver().findElement(By.cssSelector("[class~=inventory_item]"));
        Assert.assertTrue(inventoryItem.isDisplayed());

        // [attribute*=value]
        WebElement continueShopping = getWebDriver().findElement(By.cssSelector("[id*=shopping]"));
        Assert.assertTrue(continueShopping.isDisplayed());

    }

    @Test(priority = 3)
    public void testAddToCardButton() {
        addToCardButton();
        String remove = getWebDriver().findElement(By.xpath("//button [@name='remove-sauce-labs-backpack']")).getText();
        Assert.assertEquals(remove, "Remove");
    }

    @Test(priority = 4)
    public void testAddToCard() {
        addToCard();
        Assert.assertNotNull(getWebDriver().findElement(By.xpath("//div [@class='cart_quantity']")));
    }

    @Test(priority = 5)
    public void testPriceCheck() {
        addToCard();
        Assert.assertEquals(priceHomePage(0), priceCardPage());
    }

    @AfterTest
    public void tearDown() {
        getWebDriver().quit();
    }

    public void authorization() {
        List<String> userName = Arrays.stream(getWebDriver().findElement(By.id("login_credentials")).getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
        List<String> userPassword = Arrays.stream(getWebDriver().findElement(By.className("login_password")).getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .collect(Collectors.toList());
        WebElement login = getWebDriver().findElement(By.xpath("//input [@id = 'user-name']"));
        WebElement password = getWebDriver().findElement(By.xpath("//input [@id = 'password']"));
        login.click();
        login.clear();
        login.sendKeys(userName.get(0));
        password.click();
        password.clear();
        password.sendKeys(userPassword.get(0));
        WebElement loginButton = getWebDriver().findElement(By.id("login-button"));
        loginButton.click();
    }

    public void addToCard() {
        WebElement card = getWebDriver().findElement(By.xpath("// a [@class = 'shopping_cart_link']"));
        card.click();
    }

    public void addToCardButton() {
        WebElement button = getWebDriver().findElement(By.xpath("//button [@id='add-to-cart-sauce-labs-backpack']"));
        button.click();
    }

    public String priceHomePage(int value) {
        getWebDriver().get("https://www.saucedemo.com/inventory.html");
        List<String> price = getWebDriver().findElements(By.xpath("// div [@class = 'inventory_item_price']"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return price.get(value);
    }

    public String priceCardPage() {
        String price = getWebDriver().findElement(By.xpath("//div [@class='inventory_item_price']")).getText();
        return price;
    }
}
