package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertTrue;

public class AiB extends PageObjectInitializer{

    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/form[2]/div[1]/label")
    private WebElement bachelorCheckbox;


    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/table")
    private WebElement table;


    public AiB clickBachelorCheckbox(){
        WaitForElement.waitForElementToBeVisible(bachelorCheckbox);
        WaitForElement.waitForElementToBeClickable(bachelorCheckbox);
        bachelorCheckbox.click();
        return this;
    }

    public AiB isTablePresent() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0, document.body.scrollHeight / 5);");
            Thread.sleep(1000);
        }
        WaitForElement.waitForElementToBeVisible(table);
        assertTrue(table.isDisplayed());


        return this;
    }



}
