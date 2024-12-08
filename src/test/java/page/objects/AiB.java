package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AiB extends PageObjectInitializer{

    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/form[2]/div[1]/label")
    private WebElement bachelorCheckbox;


    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/table")
    private WebElement table;

    @FindBy(xpath = "//select")
    private WebElement yearSelect;



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


    public AiB select20162017(){
        WaitForElement.waitForElementToBeVisible(yearSelect);
        Select select = new Select(yearSelect);
        select.selectByIndex(8);
        return this;
    }
    public AiB verify20162017OnSelectButton(){
        Select select = new Select(yearSelect);
        String selectText = select.getFirstSelectedOption().getText();
        assertEquals("2016-2017",selectText);
        return this;
    }



}
