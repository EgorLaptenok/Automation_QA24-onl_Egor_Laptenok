package pageObjects.herokuApp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class FileDownloadPage extends BasePage {
    private final By header = By.tagName("h3");
    private By getFile(String fileName){
        return By.linkText(fileName);
    }
    public void verifyPage() {
        wait.until(textToBe(header, "File Downloader"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/download");
    }
    public void verifyPageForFall() {
        Assert.assertEquals(driver.findElement(header).getText(),"File Not Downloader", "Wrong text massage");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/download");
    }
    public void downloadFile(String file){
        click(getFile(file));
    }
}
