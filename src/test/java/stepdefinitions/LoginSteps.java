package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import page.objects.Logowanie;
import sterownik.manager.MenadzerSterownika;

public class LoginSteps {

    private Logowanie logowanie;

    @Given("I open the login page")
    public void openLoginPage() {
        logowanie = new Logowanie();
    }

    @When("I check the logo text")
    public void checkLogoText() {
        logowanie.test1();
    }

    @Then("I should see the text {string}")
    public void verifyLogoText(String expectedText) {
        String actualText = logowanie.getLogoText();
        Assert.assertEquals(actualText, expectedText, "Logo text does not match!");
    }

    @Then("I should see the Login button")
    public void i_should_see_the_login_button(){
        logowanie.getLoginButton();
    }
}
