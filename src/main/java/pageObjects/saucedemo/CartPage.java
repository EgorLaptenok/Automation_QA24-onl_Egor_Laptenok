package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.lang.module.FindException;

import static driver.DriverCreation.getDriver;

public class CartPage extends BasePage {
    private final By cart = By.className("title");
    private final By cartLabel = By.xpath("//div[@class='cart_item_label']");
    private final By cartItem = By.xpath("//div[@class='removed_cart_item']");
    private final By removeButton = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
    private final By checkoutButton = By.xpath("//button[@id='checkout']");
    private final By informationUser = By.xpath("//div[@class='summary_info_label'][1]");
    private final By buttonFinish = By.xpath("//button[@id='finish']");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(cart).getText(), "Your Cart", "Wrong cart name");
        Assert.assertTrue(getDriver().findElement(cartLabel).isDisplayed(), "Cart is Empty");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong header url");
    }

    public void removeProduct() {
        click(removeButton);
        Assert.assertFalse(getDriver().findElement(cartItem).isDisplayed(), "Cart is not empty");
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

    public void successfulPayment() {
        Assert.assertEquals(getDriver().findElement(informationUser).getText(), "Payment Information", "Disable is display");
    }

    public void clickFinish() {
        click(buttonFinish);
    }
}
