package pageObjects.baseObjects;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static driver.DriverCreation.getDriver;
@Log4j
public abstract class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;

    {
        driver = getDriver();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
    }

    protected void navigateTo(String url) {
        log.info("Navigate to :: " + url);
        driver.get(url);
    }

    protected void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        click(driver.findElement(by));
    }

    protected void click(WebElement element) {
        log.info("Click on element ::" + element);
        element.click();
    }

    protected void sendKeys(By by, CharSequence... charSequence) {
        sendKeys(driver.findElement(by), charSequence);
    }

    protected void sendKeys(WebElement element, CharSequence... charSequence) {
        log.info("Enter in element ::" + element + ", next value ::" + Arrays.toString(charSequence));
        element.click();
        element.clear();
        element.sendKeys(charSequence);
    }
    protected String getText(By by) {
        return driver.findElement(by).getText();
    }
    protected boolean isDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }
    protected void switchToFrame(By by) {
        driver.switchTo().frame(driver.findElement(by));
    }
    protected void waitForElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
