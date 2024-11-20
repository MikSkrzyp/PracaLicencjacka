package sterownik.przegladarka;
import java.lang.String;
public enum TypyPrzegladarek {
    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("edge");

    private final String przegladarka;

    TypyPrzegladarek(String przegladarka) {this.przegladarka = przegladarka;}
}