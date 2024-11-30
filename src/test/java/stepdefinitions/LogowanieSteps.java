package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.Logowanie;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static sterownik.manager.DodatkiSterownika.obecnyAdres;

public class LogowanieSteps {
    private Logowanie logowanie;


    @Given("I open the login page")
    public void openLoginPage(){
        logowanie = new Logowanie();
    }

    @When("I input correct username, passowrd and click button")
    public void inputCorrectUsernamePasswordClickButton(){
        logowanie.inputCorrectUsernamePassword().clickLoginButton();

    }
    @Then("I am moved to Home Page")
    public void assureThatYouAreOnMainPage(){
        assertEquals(obecnyAdres(),"https://www.saucedemo.com/inventory.html");
    }
}
