package driver.manager;

import configurations.ConfigurationProperties;
import org.openqa.selenium.WebDriver;
import driver.browser.BrowserGenerator;
import driver.browser.BrowserTypes;


public class DriverManager {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setDriver(BrowserTypes browserType) {
        if (driverThreadLocal.get() == null) {
            WebDriver browser = new BrowserGenerator(browserType).generateBrowser();
            driverThreadLocal.set(browser);
        }
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver has not been initialized.");
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}