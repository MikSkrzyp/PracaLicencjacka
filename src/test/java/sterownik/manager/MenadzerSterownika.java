package sterownik.manager;

import konfiguracje.WlasciwosciKonfiguracyjne;
import org.openqa.selenium.WebDriver;
import sterownik.przegladarka.GeneratorPrzegladarek;
import sterownik.przegladarka.TypyPrzegladarek;

public class MenadzerSterownika {

    private static ThreadLocal<WebDriver> sterownikThreadLocal = new ThreadLocal<>();

    private MenadzerSterownika() {
    }

    public static void ustawSterownik(TypyPrzegladarek typPrzegladarki) {
        if (sterownikThreadLocal.get() == null) {
            WebDriver przegladarka = new GeneratorPrzegladarek(typPrzegladarki).przegladarka();
            sterownikThreadLocal.set(przegladarka);
        }
    }

    public static WebDriver sterownik() {
        if (sterownikThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver nie został zainicjalizowany.");
        }
        return sterownikThreadLocal.get();
    }

    public static void porzucSterownik() {
        if (sterownikThreadLocal.get() != null) {
            sterownikThreadLocal.get().quit();
            sterownikThreadLocal.remove();
        }
    }
}
