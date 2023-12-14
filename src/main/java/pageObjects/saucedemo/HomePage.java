package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class HomePage extends BasePage {
    private final By header = By.className("app_logo");
    private final By inventoryContainer = By.xpath("//div[@class='inventory_container']");
    private final By addToCart = By.tagName("button");
    private final By addToCartText = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory ']");
    private final By cardButton = By.xpath("//a[@class='shopping_cart_link']");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name");
        Assert.assertTrue(getDriver().findElement(inventoryContainer).isDisplayed(), "Product list is Empty");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong header url");
    }

    public void clickAddToCart(Integer index) {
        click(getDriver().findElements(inventoryContainer).get(index).findElement(addToCart));
    }

    public void successfulAddToCard() {
        Assert.assertEquals(getDriver().findElement(addToCartText).getText(), "Remove", "Wrong text");
    }

    public void clickCart() {
        click(cardButton);
    }

}
