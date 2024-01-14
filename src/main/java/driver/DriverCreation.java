package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.HashMap;

import static java.io.File.separator;

public class DriverCreation {
    private static WebDriver webDriver;

    public static void createDriver(DriverTypes type) {
        if (webDriver == null) {
            switch (type) {
                case CHROME:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.setExperimentalOption("prefs", new HashMap<>() {{
                        put("profile.default_content_setting.popups", 0);
                        put("download.default_directory", System.getProperty("user.dir") + separator + "target");
                    }});
                    webDriver = new ChromeDriver(options);
                    break;
                case FIREFOX:
                    FirefoxOptions foxOptions = new FirefoxOptions();
                    foxOptions.addArguments("start-maximized");
                    webDriver = new FirefoxDriver(foxOptions);
                    break;
                case EDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("start-maximized");
                    webDriver = new EdgeDriver(edgeOptions);
                    break;
            }
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
