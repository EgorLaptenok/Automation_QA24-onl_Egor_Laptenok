package pageObjects.baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;

public abstract class BasePage {
    protected void click(By by) {
        click(getDriver().findElement(by));
    }

    protected void click(WebElement element) {
        System.out.println("Click on element ::" + element);
        element.click();
    }

    protected void sendKeys(By by, CharSequence... charSequence) {
        sendKeys(getDriver().findElement(by), charSequence);
    }

    protected void sendKeys(WebElement element, CharSequence... charSequence) {
        System.out.println("Enter in element ::" + element + ", next value ::" + Arrays.toString(charSequence));
        element.click();
        element.sendKeys(charSequence);
    }
}
