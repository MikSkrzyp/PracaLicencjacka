package konfiguracje;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoaderWlasciwosci {

    public Properties pozyskajWlasciwosiZPliku(String nazwaPliku) {

        InputStream inputStream = null;

        Properties wlasciwosci = new Properties();
        try {

            inputStream = getClass().getClassLoader().getResourceAsStream(nazwaPliku);

            if (inputStream != null) {
                wlasciwosci.load(inputStream);
            } else {
                throw new FileNotFoundException("blad");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("blad");
        } finally {
            zamknij(inputStream);
        }

        return wlasciwosci;
    }

    private void zamknij(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}