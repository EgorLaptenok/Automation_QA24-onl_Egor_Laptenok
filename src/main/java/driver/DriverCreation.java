package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import propertyUtils.PropertyReader;

import java.time.Duration;
import java.util.HashMap;

import static java.io.File.separator;

public class DriverCreation {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void createDriver(DriverTypes type) {
        if (webDriver.get() == null) {
            switch (type) {
                case CHROME:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(PropertyReader.getProperties().getProperty("browser.option").split(";"));
                    options.setExperimentalOption("prefs", new HashMap<>() {{
                        put("profile.default_content_setting.popups", 0);
                        put("download.default_directory", System.getProperty("user.dir") + separator + "target");
                    }});
                    webDriver.set(new ChromeDriver(options));
                    break;
                case FIREFOX:
                    FirefoxOptions foxOptions = new FirefoxOptions();
                    foxOptions.addArguments("start-maximized");
                    webDriver.set(new FirefoxDriver(foxOptions));
                    break;
                case EDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("start-maximized");
                    webDriver.set(new EdgeDriver(edgeOptions));
                    break;
            }
            webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
