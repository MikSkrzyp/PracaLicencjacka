package sterownik.manager;


import konfiguracje.WlasciwosciKonfiguracyjne;
import org.openqa.selenium.WebDriver;
import sterownik.przegladarka.GeneratorPrzegladarek;
import sterownik.przegladarka.TypyPrzegladarek;

public class MenadzerSterownika {

    private static ThreadLocal<WebDriver> sterownikThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<TypyPrzegladarek> przegladarkaTypeThreadLocal = new ThreadLocal<>();

    private MenadzerSterownika() {
    }

    public static void ustawSterownik(TypyPrzegladarek typPrzegladarki) {
        WebDriver przegladarka;

        if (typPrzegladarki == null) {
            typPrzegladarki = TypyPrzegladarek.valueOf(WlasciwosciKonfiguracyjne.pozyskajWlasciwosci().getProperty("browser"));
        }
        przegladarka = new GeneratorPrzegladarek(typPrzegladarki).przegladarka();

        przegladarkaTypeThreadLocal.set(typPrzegladarki);
        sterownikThreadLocal.set(przegladarka);
    }

    public static WebDriver sterownik() {
        if (sterownikThreadLocal.get() == null) {
            throw new IllegalStateException("blad");
        }
        return sterownikThreadLocal.get();
    }

    public static void porzucSterownik() {
        if (sterownikThreadLocal.get() != null) {
            sterownikThreadLocal.get().quit();
        }
        sterownikThreadLocal.remove();
        sterownikThreadLocal.remove();
    }
}
