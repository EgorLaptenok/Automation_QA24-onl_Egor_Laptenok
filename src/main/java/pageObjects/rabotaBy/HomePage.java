package pageObjects.rabotaBy;

import com.codeborne.selenide.SelenideElement;
import pageObjects.baseObjects.BaseTestSelenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BaseTestSelenide {
    private final SelenideElement search = $("input#a11y-search-input");
    private final SelenideElement button = $x("//div[contains(@class,\"group__submit_wide\")]/button[contains(@class, \"bloko-button_stretched\")]");

    public HomePage searchInput(String search) {
        this.search.should(visible).clear();
        this.search.sendKeys(search);
        return this;
    }

    public HomePage clickButton() {
        this.button.should(visible).click();
        return this;
    }
}
