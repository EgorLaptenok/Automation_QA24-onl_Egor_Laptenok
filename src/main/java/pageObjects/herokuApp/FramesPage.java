package pageObjects.herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class FramesPage extends BasePage {
    private final By header = By.xpath("//h3");
    private final By paragraph = By.xpath("//p[contains(text(),'Your content goes here.')]");
    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Frames", "Wrong header text");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/frames");
    }
    public void switchToIn(){
        driver.switchTo().frame("mce_0_ifr");
    }
    public void findElementIsParagraph(){
        Assert.assertEquals(driver.findElement(paragraph).getText(),"Your content goes here.");
    }
    public void switchToOut(){
        driver.switchTo().defaultContent();
    }
}
