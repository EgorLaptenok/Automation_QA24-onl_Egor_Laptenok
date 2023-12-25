package pageObjects.sauceDemoTwo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class CartPage extends BasePage {
    private final By cart = By.className("title");
    private final By cartLabel = By.xpath("//div[@class='cart_item_label']");
    private final By removeButton = By.cssSelector("[class='btn btn_secondary btn_small cart_button']");
    private final By cartItem = By.xpath("//div[@class='removed_cart_item']");

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(cart).getText(), "Your Cart", "Wrong cart name");
        Assert.assertTrue(driver.findElement(cartLabel).isDisplayed(), "Cart is Empty");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong header url");
    }

    public void clickRemove() {
        click(removeButton);
    }

    public void successfulRemove() {
        Assert.assertFalse(getDriver().findElement(cartItem).isDisplayed(), "Cart is not empty");
    }
}
