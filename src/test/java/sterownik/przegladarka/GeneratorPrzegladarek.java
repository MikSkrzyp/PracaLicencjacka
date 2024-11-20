package sterownik.przegladarka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;



public class GeneratorPrzegladarek {

    private TypyPrzegladarek typPrzegladarki;
    public GeneratorPrzegladarek(TypyPrzegladarek typPrzegladarki) {
        this.typPrzegladarki = typPrzegladarki;
    }

    public WebDriver przegladarka() {

        switch (typPrzegladarki) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGE:
                WebDriverManager.iedriver().setup();
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Nieznana Przegladarka");
        }
    }

}
