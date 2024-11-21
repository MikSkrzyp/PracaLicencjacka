package sterownik.manager;

import io.qameta.allure.Step;

public class DodatkiSterownika {

    @Step("Maksymilizacja okna")
    public static void powiekszOkno(){
        MenadzerSterownika.sterownik().manage().window().maximize();
    }

    @Step("Nawigowanie do: {adres}")
    public static void nawigujDoStrony(String adres){
        MenadzerSterownika.sterownik().navigate().to(adres);
    }

}