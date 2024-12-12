package page.objects;

import com.beust.ah.A;
import driver.manager.DriverManager;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class StudyProgram extends PageObjectInitializer {

    @FindBy(xpath = "//*[@id=\"taxonomy-term-714\"]/div/div/div/div/div/div/span/article/header/h2/span")
    private WebElement title;

    @FindBy(css = "#skrypt-wzr > div.row.mt-5 > div:nth-child(1) > a")
    private WebElement economicAnalyticsButton;

    @FindBy(css="#skrypt-wzr > div.row.mt-5 > div:nth-child(2) > a")
    private WebElement aiBButton;

    @FindBy(css=".decline-button")
    private WebElement cookies;

    public void assertTitle() {
        WaitForElement.waitForElementToBeVisible(title);
        assertEquals("STUDIA I STOPNIA", title.getText());
    }

    public void clickCookies() throws InterruptedException {
        Thread.sleep(2000);
        cookies.click();
    }


    public static void enterIframe(){
        DriverManager.getDriver().switchTo().frame(0);
    }
    public static void quitIframe(){
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public StudyProgram assertNumberOfCourses(){
        assertEquals(17,countNumberOfCourses());
        return new StudyProgram();
    }
    public EconomicAnalytics clickEconomicAnalytics(){
        WaitForElement.waitForElementToBeClickable(economicAnalyticsButton);
        economicAnalyticsButton.click();
        return new EconomicAnalytics();
    }
    public AiB clickAiB(){
        WaitForElement.waitForElementToBeClickable(aiBButton);
        aiBButton.click();
        return new AiB();
    }

    public static int countNumberOfCourses() {
        List<WebElement> divElements = DriverManager.getDriver().findElements(By.cssSelector(".col-auto.my-2"));

        return divElements.size();
    }
}