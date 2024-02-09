package pageObjects.myPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomePage {
    static WebDriver driver;
    private static final String absolutePath = "C:\\Users\\LENOVO\\IdeaProjects\\AQA24-onl\\Automation_QA24-onl_Egor_Laptenok\\src\\test\\java\\lesson16\\files\\hw.html";
    private final By inputName = By.xpath("//label[@class='placeholder-box name']");
    private final By inputLastname = By.xpath("//label[@class='placeholder-box lastname']");
    private final By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private final By select = By.id("city");
    private final By img = By.xpath("//img");
    private final By pText = By.xpath("//p[text()]");
    private final By link = By.xpath("//a[contains(@href,'https')]");
    private final By logo = By.xpath("//img[@alt='Google']");

    public void openURI() {
        driver = new ChromeDriver();
        driver.get("file://" + absolutePath);
    }

    public void quit() {
        driver.quit();
    }

    public void firstColumnCollection() {
        String[] table = new String[4];
        for (int i = 2, j = 0; j < table.length; i++, j++) {
            By firstColumnCollection = By.xpath("//tr[" + i + "]/td[1]");
            table[j] = driver.findElement(firstColumnCollection).getText();
        }
        List<String> valuesFromFirstColumn = new ArrayList<>(Arrays.asList(table));
        for (String value : valuesFromFirstColumn) {
            System.out.println(value);
        }
    }

    public void inputIntoFields(String name, String lastname) {
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputLastname).click();
        driver.findElement(inputLastname).sendKeys(lastname);
    }

    public void clickOnTheCheckbox() {
        driver.findElement(checkbox1).click();
    }

    public void clickOnTheSelect(String city) {
        Select dropdown = new Select(driver.findElement(select));
        dropdown.selectByValue(city);
    }

    public boolean isImgExists() {
        return !driver.findElements(img).isEmpty();
    }

    public void correctText(String text) {
        Assert.assertEquals(driver.findElement(pText).getText(), text, "Wrong text massage");
    }

    public void clickToLink() {
        driver.findElement(link).click();
        Assert.assertTrue(driver.findElement(logo).isDisplayed());
    }
}
