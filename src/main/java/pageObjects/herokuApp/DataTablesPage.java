package pageObjects.herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class DataTablesPage extends BasePage {
    private final By header = By.tagName("h3");

    public void verifyPage() {
        wait.until(textToBe(header, "Data Tables"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/tables");
    }

    public void nameConversion(int count) {
        List<WebElement> emailElements =
                driver.findElements(By.xpath("//table[@id='table1']//tr[" + count + "]//td[1]"));
        List<String> emails = emailElements.stream()
                .map(WebElement::getText)
                .map(email -> email + "@gmail.com")
                .collect(Collectors.toList());
        System.out.println(emails);
    }
}
