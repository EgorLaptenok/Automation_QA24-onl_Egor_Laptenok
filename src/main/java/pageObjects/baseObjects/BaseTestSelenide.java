package pageObjects.baseObjects;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public abstract class BaseTestSelenide {
    protected <T> T get(Class<T> classPage) {
        return driver().hasWebDriverStarted() ? page(classPage) : open(baseUrl, classPage);
    }
}
