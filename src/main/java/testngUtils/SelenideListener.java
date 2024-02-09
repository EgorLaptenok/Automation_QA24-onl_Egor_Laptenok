package testngUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;

import static propertyUtils.PropertyReader.setUpProperty;
import static com.codeborne.selenide.Configuration.*;
import static propertyUtils.PropertyReader.getProperties;

public class SelenideListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        if (System.getProperties().containsKey("config")) {
            setUpProperty(System.getProperty("config"));
            setUpSelenideConfigurations();
        }
    }
    public void setUpSelenideConfigurations() {
        baseUrl = getProperties().getProperty("baseUrl");
        headless = Boolean.parseBoolean(getProperties().getProperty("headless"));
        timeout = Long.parseLong(getProperties().getProperty("timeout"));
    }
}
