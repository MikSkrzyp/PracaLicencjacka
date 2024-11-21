package konfiguracje;

import java.util.Properties;

public class WlasciwosciKonfiguracyjne {

    private static Properties wlasciwosci;

    private WlasciwosciKonfiguracyjne() {
    }



    public static void ustawWlasciwosci(Properties wlasciwosci) {
        WlasciwosciKonfiguracyjne.wlasciwosci = wlasciwosci;
    }

    public static Properties pozyskajWlasciwosci() {
        if (wlasciwosci == null) {
            throw new IllegalStateException("Ustaw pierw wlasciwosci!");
        }
        return wlasciwosci;
    }

}