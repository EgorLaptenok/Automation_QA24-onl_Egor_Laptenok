package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleWebDriver {
    private static WebDriver webDriver;
    {
        if(webDriver == null) {
            webDriver = new ChromeDriver(chromeOptions());
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
    public static ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
