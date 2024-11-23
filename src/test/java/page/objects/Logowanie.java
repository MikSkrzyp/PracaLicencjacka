package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.CzekajNaElement;

import static org.testng.AssertJUnit.assertEquals;


public class Logowanie extends KonfiguratorPageObjects{


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    private WebElement logo;




    public Logowanie test1(){
        CzekajNaElement.czekajAzElementWidoczny(logo);
       assertEquals(logo.getText(),"Swag Labs");
    return this;
    }

    public String getLogoText() {
        CzekajNaElement.czekajAzElementWidoczny(logo);
        return logo.getText();
    }




}
