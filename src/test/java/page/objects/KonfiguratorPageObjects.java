package page.objects;

import org.openqa.selenium.support.PageFactory;
import sterownik.manager.MenadzerSterownika;

public class KonfiguratorPageObjects {
    public KonfiguratorPageObjects(){
        PageFactory.initElements(MenadzerSterownika.sterownik(),this);
    }
}
