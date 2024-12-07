package page.objects;

import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;

public class EconomicAnalytics extends PageObjectInitializer{

    @FindBy(css = ".komunikat")
    private WebElement economicAnalyticsAlert;


    public EconomicAnalytics checkURL(){
        assertEquals("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia", DriverExtensions.getCurrentUrl());
        return this;
    }

    public EconomicAnalytics checkAlert() throws InterruptedException {
       DriverManager.getDriver().switchTo().frame(0);
       Thread.sleep(3000);
        assertEquals("Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.",economicAnalyticsAlert.getText());
        return this;
    }

}
