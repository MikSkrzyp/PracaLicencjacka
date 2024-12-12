package page.objects;

import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import waits.WaitForElement;

import static org.testng.AssertJUnit.*;

public class EconomicAnalytics extends PageObjectInitializer{

    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/div[3]")
    private WebElement title;


    @FindBy(css = "#skrypt-wzr > form:nth-child(7) > div:nth-child(7) > label > input")
    private WebElement bachelorRadio;

    @FindBy(css = "#skrypt-wzr > form > div > a")
    private WebElement pdfIcon;


    public EconomicAnalytics assertTitle(){
        WaitForElement.waitForElementToBeVisible(title);
        assertEquals("Analityka gospodarcza",title.getText());

        return new EconomicAnalytics();
    }

    public EconomicAnalytics clickBachelorRadio(){
        WaitForElement.waitForElementToBeClickable(bachelorRadio);
        bachelorRadio.click();
        return new EconomicAnalytics();
    }
    public EconomicAnalytics assertVisibilityOfPdfIcon() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(pdfIcon.isDisplayed());

        return new EconomicAnalytics();
    }
}