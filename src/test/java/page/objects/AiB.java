package page.objects;

import com.beust.ah.A;
import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AiB extends PageObjectInitializer{

    @FindBy(css = "#skrypt-wzr > table")
    private WebElement table;

    @FindBy(css = "#skrypt-wzr > form:nth-child(7) > div:nth-child(7) > label > input")
    private WebElement bachelorRadio;

    @FindBy(css = "#skrypt-wzr > table > thead > tr")
    private WebElement rowWithColumnNames;


    @FindBy(css = "#skrypt-wzr > form > div > a")
    private WebElement pdfButton;

    public AiB clickBachelorRadio() {
        WaitForElement.waitForElementToBeVisible(bachelorRadio);
        new Actions(DriverManager.getDriver()).scrollByAmount(0,200).perform();
        bachelorRadio.click();
        return new AiB();
    }

    public AiB assertTableIsPresent(){
        WaitForElement.waitForElementToBeVisible(table);
        assertTrue(table.isDisplayed());

        return new AiB();
    }

    public AiB assertNumberOfRows(){
        assertEquals(57,getTableRowCount());


        return new AiB();
    }



    public static int getTableRowCount() {
        List<WebElement> tableRows = DriverManager.getDriver().findElements(By.tagName("tr"));
        return tableRows.size();
    }

    public AiB assertRowsWithColumnNames(){
        List<WebElement> thList = rowWithColumnNames.findElements(By.tagName("th"));
        String[] columnNames = {"Lp.", "Przedmiot", "ECTS", "Roz.", "Suma", "Wyk.", "Ćw.", "Lab.", "Sem.", "Pra.", "Jednostka"};

        for(int i = 0; i<thList.size();i++){
            String actualColumnName = thList.get(i).getText();
            String expectedColumnName = columnNames[i];
            assertEquals(expectedColumnName,actualColumnName);
        }


        return new AiB();
    }

    public AiBPDF clickPDFButton(){
        WaitForElement.waitForElementToBeClickable(pdfButton);
        pdfButton.click();
        return new AiBPDF();
    }

}
