package testy;

import io.qameta.allure.Step;
import konfiguracje.LoaderWlasciwosci;
import konfiguracje.WlasciwosciKonfiguracyjne;
import org.testng.annotations.*;
import sterownik.manager.DodatkiSterownika;
import sterownik.manager.MenadzerSterownika;
import sterownik.przegladarka.TypyPrzegladarek;

import java.util.Properties;


public class KonfiguratorTestow {


    @BeforeClass
    public void beforeClass() {
        LoaderWlasciwosci loaderWlasciwosci = new LoaderWlasciwosci();
        Properties wlasciwosciZPliku = loaderWlasciwosci.pozyskajWlasciwosiZPliku("konfiguracje.properties");
        WlasciwosciKonfiguracyjne.ustawWlasciwosci(wlasciwosciZPliku);
    }

    @Parameters("przegladarka")
    @BeforeMethod
    public void beforeTest(@Optional TypyPrzegladarek typPrzegladarki) {
        MenadzerSterownika.ustawSterownik(typPrzegladarki);
        MenadzerSterownika.sterownik();
        DodatkiSterownika.powiekszOkno();
        DodatkiSterownika.nawigujDoStrony(WlasciwosciKonfiguracyjne.pozyskajWlasciwosci().getProperty("url"));
    }

    @AfterMethod
    public void afterTest() {
        MenadzerSterownika.porzucSterownik();
    }

}