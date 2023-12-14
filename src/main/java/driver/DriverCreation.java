package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverCreation {
    private static WebDriver webDriver;

    public static void createDriver(DriverTypes type) {
        if (webDriver == null) {
            switch (type) {
                case CHROME:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
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
        webDriver.quit();
    }
}
