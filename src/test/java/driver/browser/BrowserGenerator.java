package driver.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import driver.browser.BrowserTypes;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserGenerator {

    private BrowserTypes browserType;

    public BrowserGenerator(BrowserTypes browserType) {
        this.browserType = browserType;
    }

    public WebDriver generateBrowser() {

        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            default:
                throw new IllegalStateException("Unknown browser");
        }
    }
}