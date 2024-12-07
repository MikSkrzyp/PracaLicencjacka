package driver.manager;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DriverExtensions {

    @Step("Maximizing window")
    public static void maximizeWindow() {
        DriverManager.getDriver().manage().window().maximize();
    }

    @Step("Navigating to: {url}")
    public static void navigateToPage(String url) {
        DriverManager.getDriver().navigate().to(url);
    }

    public static String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void turnEnglish() {
        DriverManager.getDriver().findElement(By.id("english")).click();
    }
}