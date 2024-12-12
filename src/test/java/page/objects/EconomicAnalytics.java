package page.objects;

import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import waits.WaitForElement;

import javax.swing.*;

import static org.testng.AssertJUnit.*;

public class EconomicAnalytics extends PageObjectInitializer{

    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/div[3]")
    private WebElement title;


    @FindBy(css = "#skrypt-wzr > form:nth-child(7) > div:nth-child(7) > label > input")
    private WebElement bachelorRadio;


    @FindBy(css = "body > div")
    private WebElement iframe;

    @FindBy(css = "#skrypt-wzr > form > div > a")
    private WebElement pdfIcon;
    public static void enterIframe(){
        DriverManager.getDriver().switchTo().frame(0);
    }
    public static void quitIframe(){
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public EconomicAnalytics assertTitle(){
        WaitForElement.waitForElementToBeVisible(title);
        assertEquals("Analityka gospodarcza",title.getText());

        return new EconomicAnalytics();
    }

    public EconomicAnalytics clickBachelorRadio() {
        WaitForElement.waitForElementToBeVisible(bachelorRadio);
       new Actions(DriverManager.getDriver()).scrollByAmount(0,500).perform();
        bachelorRadio.click();
        return new EconomicAnalytics();
    }
    public EconomicAnalytics assertVisibilityOfPdfIcon() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(pdfIcon.isDisplayed());

        return new EconomicAnalytics();
    }
}