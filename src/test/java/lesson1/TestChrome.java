package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testngUtils.Retry;


public class TestChrome{
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.by/ ");
    }

    @Test(priority = 2,retryAnalyzer = Retry.class)
    public void search() {
        inputFields("Привет, мир");
        WebElement results = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(results.isDisplayed(), "Поиск не отработал корректно");
    }

    @Test(priority = 1)
    public void testSearchSkipTests() {
        inputFields("-DskipTests=true");
        WebElement error = driver.findElement(By.xpath("//p[@style='margin-top:1em']"));
        Assert.assertTrue(error.isDisplayed(), "Элемент не отображается");
        WebElement element = driver.findElement(By.id("logo"));
        element.click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    private void inputFields(String value) {
        WebElement fields = driver.findElement(By.name("q"));
        fields.clear();
        fields.sendKeys(value);
        fields.submit();
    }
}
