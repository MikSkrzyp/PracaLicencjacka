package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import konfiguracje.LoaderWlasciwosci;
import konfiguracje.WlasciwosciKonfiguracyjne;
import sterownik.manager.DodatkiSterownika;
import sterownik.manager.MenadzerSterownika;
import sterownik.przegladarka.TypyPrzegladarek;

import java.util.Properties;

public class TestHooks {

    @Before(order = 0)
    public void loadProperties() {
        LoaderWlasciwosci loaderWlasciwosci = new LoaderWlasciwosci();
        Properties properties = loaderWlasciwosci.pozyskajWlasciwosiZPliku("konfiguracje.properties");
        WlasciwosciKonfiguracyjne.ustawWlasciwosci(properties);
    }

    @Before(order = 1)
    public void setupDriver(Scenario scenario) {
        String browser = WlasciwosciKonfiguracyjne.pozyskajWlasciwosci().getProperty("przegladarka", "CHROME").toUpperCase();
        String baseUrl = WlasciwosciKonfiguracyjne.pozyskajWlasciwosci().getProperty("url");
        MenadzerSterownika.ustawSterownik(TypyPrzegladarek.valueOf(browser));

        DodatkiSterownika.powiekszOkno();
        DodatkiSterownika.nawigujDoStrony(baseUrl);

        System.out.println("Running Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.err.println("Scenario failed: " + scenario.getName());
        }
        MenadzerSterownika.porzucSterownik();
    }
}
