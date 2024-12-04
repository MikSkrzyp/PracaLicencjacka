package waits;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElement {
    private static WebDriverWait getWaitForElement() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
    }

    public static void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = getWaitForElement();
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = getWaitForElement();
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}