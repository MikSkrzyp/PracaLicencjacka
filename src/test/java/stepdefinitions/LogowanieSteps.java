package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.Logowanie;

import static driver.manager.DriverExtensions.getCurrentUrl;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LogowanieSteps {
    private Logowanie logowanie;


    @Given("I open the login page")
    public void openLoginPage(){
        logowanie = new Logowanie();
    }

    @When("I input correct username, password and click button")
    public void inputCorrectUsernamePasswordClickButton(){
        logowanie.inputCorrectUsernamePassword().clickLoginButton();

    }
    @Then("I am moved to Home Page")
    public void assureThatYouAreOnMainPage(){
        assertEquals(getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
