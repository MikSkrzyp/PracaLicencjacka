package page.objects;

import com.beust.ah.A;
import driver.manager.DriverManager;
import io.cucumber.java.an.E;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class StudyProgram extends PageObjectInitializer {

    @FindBy(xpath = "//*[@id=\"taxonomy-term-714\"]/div/div/div/div/div/div/span/article/header/h2/span")
    private WebElement title;

    @FindBy(css = "#skrypt-wzr > div.row.mt-5 > div:nth-child(1) > a")
    private WebElement economicAnalyticsButton;

    @FindBy(css="#skrypt-wzr > div.row.mt-5 > div:nth-child(2) > a")
    private WebElement aiBButton;

    @FindBy(css=".decline-button")
    private WebElement cookies;

    @FindBy(css = "#skrypt-wzr > div.alert.alert-secondary.mt-4.fw-bold")
    private WebElement aiBTItleInside;

    @FindBy(css="#accessibility_settings_toggle > img")
    private WebElement accesibilityButton;

    @FindBy(css="#accessibility_settings")
    private WebElement accesiblitySettings;

    @FindBy(css="ol.breadcrumb")
    private WebElement breadcrumbContainer;

    @FindBy(css = "#collapseExample > ul > li:nth-child(2) > a")
    private WebElement masterStudiesLink;

    @FindBy(css="[aria-label='Nagłówek']")
    private WebElement header;

    @FindBy(className = "site-footer")
    private WebElement footer;


    public void assertTitle() {
        WaitForElement.waitForElementToBeVisible(title);
        assertEquals("STUDIA I STOPNIA", title.getText());
    }

    public void clickCookies() throws InterruptedException {
        Thread.sleep(2000);
        cookies.click();
    }


    public StudyProgram enterIframe() throws InterruptedException {
        Thread.sleep(2000);
        new Actions(DriverManager.getDriver()).scrollByAmount(0,200).perform();
        DriverManager.getDriver().switchTo().frame(0);

        return new StudyProgram();
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

    public StudyProgram assertThatAiBTitleInsideIsNotVisible() throws InterruptedException {
        Thread.sleep(2000);


        boolean isAiBTitleAbsent = DriverManager.getDriver().findElements(By.cssSelector("#skrypt-wzr > div.alert.alert-secondary.mt-4.fw-bold")).isEmpty();


        assertTrue(isAiBTitleAbsent);

        return new StudyProgram();
    }

    public StudyProgram clickAccessibilityButton() throws InterruptedException {
        Thread.sleep(2000);
        accesibilityButton.click();
        return new StudyProgram();
    }

    public StudyProgram assertVisibilityOfAccessibilitySettings() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(accesiblitySettings.isDisplayed());
        return new StudyProgram();
    }

    public StudyProgram assertPath() {
        List<WebElement> breadcrumbItems = breadcrumbContainer.findElements(By.cssSelector("li.breadcrumb-item"));
        StringBuilder actualPathBuilder = new StringBuilder();
        for (WebElement item : breadcrumbItems) {
            actualPathBuilder.append(item.getText());
            actualPathBuilder.append(" / ");
        }

        String actualPath = actualPathBuilder.toString().replaceAll(" / $", "");

        assertEquals("Strona główna / Wydział / Programy studiów / Studia w języku polskim",actualPath);

        return new StudyProgram();
    }

    public MasterStudies goToMasterStudies(){
        WaitForElement.waitForElementToBeClickable(masterStudiesLink);
        masterStudiesLink.click();
        return new MasterStudies();
    }

    public StudyProgram assertVisibilityOfHeaderFooter(){
        WaitForElement.waitForElementToBeVisible(header);
        assertTrue(header.isDisplayed());
        WaitForElement.waitForElementToBeVisible(footer);
        assertTrue(footer.isDisplayed());

        return new StudyProgram();
    }


}