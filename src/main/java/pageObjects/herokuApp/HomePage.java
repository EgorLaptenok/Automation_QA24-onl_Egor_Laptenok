package pageObjects.herokuApp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;
public class HomePage extends BasePage {
    private final By header = By.tagName("h1");
    private final By headerContent = By.xpath("//div[@id='content']");

    private By getItemLocator(String item){
        return By.linkText(item);
    }
    public void open(String url){
        navigateTo(url);
    }
    public void verifyPage(){
        Assert.assertEquals(getDriver().findElement(header).getText(),"Welcome to the-internet","Wrong header text");
        Assert.assertTrue(getDriver().findElement(headerContent).isDisplayed(),"Page is empty");
    }
    public void clickOnItem(HomePageItem item){
        click(getItemLocator(item.getItem()));
    }
}
