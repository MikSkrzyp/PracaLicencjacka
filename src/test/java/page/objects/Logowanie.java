package page.objects;

import io.cucumber.java.gl.Logo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static data.TestData.username;
import static data.TestData.password;

public class Logowanie extends PageObjectInitializer{


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    private WebElement logo;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id="user-name")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;


    public Logowanie inputCorrectUsernamePassword(){
        WaitForElement.waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        return this;
    }

    public Home clickLoginButton(){
        WaitForElement.waitForElementToBeVisible(loginButton);
        loginButton.click();
        return new Home();
    }




}
