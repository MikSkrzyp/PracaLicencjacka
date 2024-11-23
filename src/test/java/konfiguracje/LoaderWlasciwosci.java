package konfiguracje;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoaderWlasciwosci {

    public Properties pozyskajWlasciwosiZPliku(String nazwaPliku) {
        Properties wlasciwosci = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nazwaPliku)) {
            if (inputStream != null) {
                wlasciwosci.load(inputStream);
            } else {
                throw new IllegalArgumentException("Plik konfiguracji '" + nazwaPliku + "' nie znaleziony.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas ładowania pliku konfiguracji '" + nazwaPliku + "'.", e);
        }

        return wlasciwosci;
    }
}
