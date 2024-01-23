package pageFactory.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.List;

import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage implements Page<ProductPage> {
    @FindBys({@FindBy(className = "inventory_item")})
    List<WebElement> productList;
    @FindBy(className = "title" )
    WebElement productsTitle;
    @FindBy(css = "button[id='react-burger-menu-btn']" )
    WebElement burgerMenu;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']" )
    WebElement logoutButton;

    private final By addToCard = By.tagName("button");
    public ProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ProductPage clickAddToCard(Integer index) {
        click(productList.get(index).findElement(addToCard));
        return this;
    }
    public ProductPage verifyPage() {
        Assert.assertEquals(productsTitle.getText(), "Products", "User is not logged");
        return this;
    }
    public ProductPage clickBurger() {
        click(burgerMenu);
        return this;
    }
    public ProductPage clickLogOut() {
        click(logoutButton);
        return this;
    }
    public ProductPage logOut(){
        clickBurger().clickLogOut();
        return this;
    }
    @Override
    public ProductPage waitUntilPageLoaded(){
        return this;
    }
}
