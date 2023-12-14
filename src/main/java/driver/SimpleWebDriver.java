package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleWebDriver {
    private static WebDriver webDriver;

    public static void setUpWebDriver(String url) {
        if (webDriver == null) {
            webDriver = new ChromeDriver(chromeOptions());
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            webDriver.get(url);
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void quit() {
        webDriver.quit();
    }

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
