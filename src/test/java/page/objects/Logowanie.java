package page.objects;

import io.cucumber.java.gl.Logo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import waits.CzekajNaElement;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class Logowanie extends KonfiguratorPageObjects{


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    private WebElement logo;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public Logowanie test1(){
        CzekajNaElement.czekajAzElementWidoczny(logo);
       assertEquals(logo.getText(),"Swag Labs");
    return this;
    }

    public Logowanie getLoginButton(){
        CzekajNaElement.czekajAzElementWidoczny(loginButton);
        assertTrue(loginButton.isDisplayed());
        return this;
    }

    public String getLogoText() {
        CzekajNaElement.czekajAzElementWidoczny(logo);
        return logo.getText();
    }




}
