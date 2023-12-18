package pageObjects.herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class DynamicControlsPage extends BasePage {
    private final By header = By.xpath("//h4[1]");
    private final By removeButton = By.xpath("//button[@onclick='swapCheckbox()']");
    private final By enableButton = By.xpath("//button[@onclick='swapInput()']");
    private final By text = By.xpath("//p[@id='message']");
    private final By checkbox = By.id("checkbox");
    private final By enableInput = By.xpath("//input[@type='text']");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Dynamic Controls", "Wrong header text");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/dynamic_controls");
    }

    public void successfulGoneText() {
        wait.until(ExpectedConditions.textToBe(text, "It's gone!"));
    }

    public void successfulCheckbox() {
        Assert.assertEquals(driver.findElements(checkbox).size(), 0, "Element present");
    }

    public void inputIsNotEnable() {
        Assert.assertFalse(driver.findElement(enableInput).isEnabled(), "Input is enable");
    }

    public void clickRemoveButton() {
        click(removeButton);
    }

    public void clickEnableButton() {
        click(enableButton);
    }

    public void successfulEnableText() {
        wait.until(ExpectedConditions.textToBe(text, "It's enabled!"));
    }

    public void inputIsEnable() {
        Assert.assertTrue(driver.findElement(enableInput).isEnabled(), "Input is not enable");
    }

}
