package lesson2;

import driver.SimpleWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.getWebDriver;

public class Task_5 {
    private SimpleWebDriver webDriver = new SimpleWebDriver();

    @BeforeTest
    public void setUp() {
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test
    public void testPositiveLength() {
        inputFields("11,000", "4,500", "250", "200", "20", "750", "9", "95");
        WebElement fieldDirect = getWebDriver().findElement(By.name("calc_direct"));
        fieldDirect.click();
        WebElement length = getWebDriver().findElement(By.xpath("//option[@value='tow']"));
        length.click();
        calculationButton();
        result("49.22 м2.", "1013 шт.", "51 шт.", "38250 руб.", "7 шт.", "14 шт.");
    }

    @Test
    public void testPositiveWidth() {
        inputFields("11,000", "4,500", "250", "200", "20", "750", "9", "95");
        WebElement fieldDirect = getWebDriver().findElement(By.name("calc_direct"));
        fieldDirect.click();
        WebElement width = getWebDriver().findElement(By.xpath("//option[@value='toh']"));
        width.click();
        calculationButton();
        result("49.22 м2.", "991 шт.", "50 шт.", "37500 руб.", "9 шт.", "30 шт.");
    }

    @Test
    public void testNegative() {
        inputFields("-5", "0", "1.38", "0.193", "-20", "-750", "0", "0.95");
        WebElement fieldDirect = getWebDriver().findElement(By.name("calc_direct"));
        fieldDirect.click();
        WebElement width = getWebDriver().findElement(By.xpath("//option[@value='toh']"));
        width.click();
        calculationButton();
        result("4.99 м2.", "1000 шт.", "50 шт.", "3750 руб.", "0 шт.", "98 шт.");
    }

    @AfterTest
    public void tearDown() {
        getWebDriver().quit();
    }

    private void inputFields(String... value) {
        WebElement fieldWidth = getWebDriver().findElement(By.name("calc_roomwidth"));
        WebElement fieldHeight = getWebDriver().findElement(By.name("calc_roomheight"));
        WebElement fieldLamWidth = getWebDriver().findElement(By.name("calc_lamwidth"));
        WebElement fieldLamHeight = getWebDriver().findElement(By.name("calc_lamheight"));
        WebElement fieldInPack = getWebDriver().findElement(By.name("calc_inpack"));
        WebElement fieldPrice = getWebDriver().findElement(By.name("calc_price"));
        WebElement fieldWallDist = getWebDriver().findElement(By.name("calc_walldist"));
        WebElement fieldBias = getWebDriver().findElement(By.name("calc_bias"));
        WebElement[] field = {fieldWidth, fieldHeight, fieldLamWidth, fieldLamHeight, fieldInPack, fieldPrice, fieldWallDist, fieldBias};
        for (int i = 0; i < field.length; i++) {
            field[i].click();
            field[i].sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            field[i].sendKeys(value[i]);
        }
    }

    public void calculationButton() {
        WebElement button = getWebDriver().findElement(By.xpath("//input[@value='Рассчитать']"));
        button.click();
    }

    public void result(String... valueResult) {
        String resultLam = getWebDriver().findElement(By.id("s_lam")).getText();
        String resulCount = getWebDriver().findElement(By.id("l_count")).getText();
        String resulPacks = getWebDriver().findElement(By.id("l_packs")).getText();
        String resulPrice = getWebDriver().findElement(By.id("l_price")).getText();
        String resulOver = getWebDriver().findElement(By.id("l_over")).getText();
        String resulTrash = getWebDriver().findElement(By.id("l_trash")).getText();
        String[] result = {resultLam, resulCount, resulPacks, resulPrice, resulOver, resulTrash};
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(result[i], valueResult[i]);
        }
    }
}
