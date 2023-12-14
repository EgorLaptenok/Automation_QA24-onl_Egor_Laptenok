package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class FinishPage extends BasePage {
    private final By finish = By.className("title");
    private final By finishOrder = By.xpath("//div[@id='checkout_complete_container']");
    private final By finishCompleted = By.xpath("//h2[@class='complete-header']");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(finish).getText(), "Checkout: Complete!", "Wrong information name");
        Assert.assertTrue(getDriver().findElement(finishOrder).isDisplayed(), "Info is Empty");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "Wrong header url");
        Assert.assertEquals(getDriver().findElement(finishCompleted).getText(), "Thank you for your order!", "Wrong information operation");
    }
}
