package pageObjects.rw;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class FormOfProtection {
    private final SelenideElement button = $("button#proceed-button");
    private final SelenideElement buttonBack = $("button#primary-button");

    public FormOfProtection clickButton() {
        button.should(enabled).click();
        return this;
    }

    public FormOfProtection clickButtonBack() {
        buttonBack.should(enabled).click();
        return this;
    }
}
