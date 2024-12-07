package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;

public class StudyProgram extends PageObjectInitializer {

    @FindBy(xpath = "//*[@id=\"taxonomy-term-714\"]/div/div/div/div/div/div/span/article/header/h2/span")
    private WebElement title;

    @FindBy(xpath = "//div[contains(text(), 'Analityka gospodarcza')]")
    private WebElement economicAnalyticsLink;

    @FindBy(xpath = "//*[@id=\"popup-buttons\"]/button[1]")
    private WebElement cookiesAlert;



    public void clickCookiesAlert() throws InterruptedException {
        Thread.sleep(3000);
        cookiesAlert.click();


    }

    public void assertTitle() {
        WaitForElement.waitForElementToBeVisible(title);
        assertEquals("STUDIA I STOPNIA", title.getText());
    }



    public EconomicAnalytics clickOnAnalitykaGospodarczaLink(){
        DriverManager.getDriver().switchTo().frame(0);
        WaitForElement.waitForElementToBeClickable(economicAnalyticsLink);
        economicAnalyticsLink.click();
        DriverManager.getDriver().switchTo().defaultContent();
        return new EconomicAnalytics();
    }

}
