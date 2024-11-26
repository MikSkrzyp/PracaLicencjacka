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
        String browser = "CHROME"; // Default browser is Chrome

        // Check for browser tag in the scenario
        if (scenario.getSourceTagNames().contains("@firefox")) {
            browser = "FIREFOX";
        } else if (scenario.getSourceTagNames().contains("@chrome")) {
            browser = "CHROME";
        }
        else if (scenario.getSourceTagNames().contains("@edge")) {
            browser = "EDGE";
        }

        String baseUrl = WlasciwosciKonfiguracyjne.pozyskajWlasciwosci().getProperty("url");
        MenadzerSterownika.ustawSterownik(TypyPrzegladarek.valueOf(browser));

        DodatkiSterownika.powiekszOkno();
        DodatkiSterownika.nawigujDoStrony(baseUrl);

        System.out.println("Running Scenario: " + scenario.getName() + " on browser: " + browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.err.println("Scenario failed: " + scenario.getName());
        }
        MenadzerSterownika.porzucSterownik();
    }
}
