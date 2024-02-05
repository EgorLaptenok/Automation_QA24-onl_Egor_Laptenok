package pageObjects.rw;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement from = $("#acFrom");
    private final SelenideElement to = $("#acTo");
    private final SelenideElement search = $("input[type='submit']");
    private final SelenideElement date = $("input#yDate");
    private final SelenideElement toStation = $("#tabForm2");
    private final SelenideElement searchStation = $("#acStation");
    private final SelenideElement date2 = $("input#yDate2");

    public HomePage enterFrom(String from) {
        this.from.should(visible).sendKeys(from);
        return this;
    }

    public HomePage enterTo(String to) {
        this.to.should(visible).sendKeys(to);
        return this;
    }

    public HomePage enterDate(String date) {
        this.date.should(visible).sendKeys(date);
        return this;
    }

    public HomePage clickSearch() {
        this.search.should(enabled).click();
        return this;
    }

    public HomePage switchToStation() {
        this.toStation.should(enabled).click();
        return this;
    }

    public HomePage enterSearchStation(String searchStation) {
        this.searchStation.should(visible).sendKeys(searchStation);
        this.searchStation.pressEnter();
        return this;
    }

    public HomePage enterDate2(String date2) {
        this.date2.should(visible).sendKeys(date2);
        return this;
    }
}
