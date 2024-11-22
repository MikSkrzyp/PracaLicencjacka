package waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sterownik.manager.MenadzerSterownika;

import java.time.Duration;

public class CzekajNaElement {
    private static WebDriverWait getCzekajNaElement() {
        return new WebDriverWait(MenadzerSterownika.sterownik(), Duration.ofSeconds(5));
    }

    public static void czekajAzElementWidoczny(WebElement element) {
        WebDriverWait czekaj = getCzekajNaElement();
        czekaj.until(ExpectedConditions.visibilityOf(element));
    }

    public static void czekajAzElementKlikalny(WebElement element) {
        WebDriverWait czekaj = getCzekajNaElement();
        czekaj.until(ExpectedConditions.elementToBeClickable(element));
    }
}
