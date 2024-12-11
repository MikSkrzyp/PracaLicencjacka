package page.objects;

import driver.manager.DriverManager;
import io.cucumber.java.pl.Kiedy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Staff extends PageObjectInitializer{


    @FindBy(css = "#skrypt-wzr > div.container > div:nth-child(2) > a")
    private WebElement drAntonowiczName;

    @FindBy(css = "#skrypt-wzr > form > div > button.btn.btn-ug.flex-fill.px-0")
    private WebElement dydaktycyButton;

    public static void enterIframe(){
        DriverManager.getDriver().switchTo().frame(0);
    }
    public static void quitIframe(){
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public Staff assertDrAnotnowiczName(){
        WaitForElement.waitForElementToBeVisible(drAntonowiczName);
        assertEquals("dr Alicja Antonowicz",drAntonowiczName.getText());
        return new Staff();
    }

    public Staff clickDydaktycyButton(){
        WaitForElement.waitForElementToBeClickable(dydaktycyButton);
        dydaktycyButton.click();
        return new Staff();
    }
    public AiB assertNumberOfEmployees() throws InterruptedException {
        Thread.sleep(2);
        assertEquals(147,countDivsWithTitleTelefon());
        return new AiB();
    }
    public static int countDivsWithTitleTelefon() {
        List<WebElement> divElements = DriverManager.getDriver().findElements(By.xpath("//div[@title='telefon']"));

        return divElements.size();
    }


}
