package pageObjects.sauceDemoTwo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class ProductsPage extends BasePage {
    private final By productsTitle = By.className("title");
    private final By burgerMenu = By.cssSelector("button[id='react-burger-menu-btn']");
    private final By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");
    private final By allItemButton = By.cssSelector("a[id='inventory_sidebar_link']");
    private final By cartButton = By.cssSelector("[class='shopping_cart_link']");
    private final By addToCartButton = By.cssSelector("[class='btn btn_primary btn_small btn_inventory']");

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(productsTitle).getText(), "Products", "User is not logged");
    }

    public void clickBurger() {
        click(burgerMenu);
    }

    public void clickLogOut() {
        click(logoutButton);
    }

    public void clickAllItem() {
        click(allItemButton);
    }

    public void clickCart() {
        click(cartButton);
    }

    public void clickItem(String product) {
        click(driver.findElement(By.xpath("//div[text()='" + product + "']")));
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }
    public void clickItemCount(int count){
        String[] item =  {"Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"};
        click(driver.findElement(By.xpath("//div[text()='" + item[count] + "']")));
    }
}
