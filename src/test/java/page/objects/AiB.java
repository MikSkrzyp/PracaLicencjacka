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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.*;

public class AiB extends PageObjectInitializer{

    @FindBy(css = "#skrypt-wzr > table")
    private WebElement table;

    @FindBy(css = "#skrypt-wzr > form:nth-child(7) > div:nth-child(7) > label > input")
    private WebElement bachelorRadio;

    @FindBy(css = "#skrypt-wzr > table > thead > tr")
    private WebElement rowWithColumnNames;

    @FindBy(css = "#skrypt-wzr > form > div > a")
    private WebElement pdfButton;

    @FindBy(css="#skrypt-wzr > img")
    private WebElement image;


    @FindBy(css="#skrypt-wzr > a")
    private WebElement getBackButton;

    @FindBy(css="#skrypt-wzr > table > tbody > tr:nth-child(1) > td")
    private WebElement tabelaOF1TermTitle;

    @FindBy(css="#skrypt-wzr > table > tbody > tr:nth-child(9) > td")
    private WebElement tableOf2TermTitle;

    @FindBy(css="#skrypt-wzr > p.komunikat")
    private WebElement alert;

    @FindBy(css="#skrypt-wzr > table > tbody > tr")
    private WebElement tableRowSelector;


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

    public AiB assertImage(){
        WaitForElement.waitForElementToBeVisible(image);
        String imgSRC = image.getAttribute("src");

        assertEquals("https://old.wzr.ug.edu.pl/.foto/specjalnosci/naglowek/spec_50.png",imgSRC);

        return new AiB();
    }

    public StudyProgram getBackToStudyPrograMPage() {
        WaitForElement.waitForElementToBeVisible(getBackButton);
        new Actions(DriverManager.getDriver()).scrollByAmount(0,400).perform();
        getBackButton.click();
        return new StudyProgram();
    }

    public AiB assertTitleOF1TermTable(){
        WaitForElement.waitForElementToBeVisible(tabelaOF1TermTitle);
        assertEquals("SEMESTR I",tabelaOF1TermTitle.getText())
;
        return new AiB();
    }

    public AiB asserValuesOfRowsOF1TermTable() {
        WaitForElement.waitForElementToBeVisible(DriverManager.getDriver().findElement(By.tagName("tbody")));


        WebElement tbody = DriverManager.getDriver().findElement(By.tagName("tbody"));


        List<WebElement> rows = tbody.findElements(By.tagName("tr"));


        List<List<String>> expectedData = Arrays.asList(
                Arrays.asList("SEMESTR I"),
                Arrays.asList("1.", "Informatyka ekonomiczna", "7", "E", "60", "15", "-", "45", "-", "-", "Katedra Informatyki Ekonomicznej"),
                Arrays.asList("2.", "Język angielski 1", "1", "Z", "30", "-", "30", "-", "-", "-", "Centrum Języków Obcych"),
                Arrays.asList("3.", "Makroekonomia", "5", "E", "45", "30", "15", "-", "-", "-", "Katedra Bankowości i Finansów / Wydział Ekonomiczny"),
                Arrays.asList("4.", "Matematyka", "6", "Z", "60", "30", "30", "-", "-", "-", "Katedra Ekonometrii / Katedra Statystyki"),
                Arrays.asList("5.", "Systemy operacyjne", "7", "Z", "75", "15", "-", "60", "-", "-", "Katedra Informatyki Ekonomicznej"),
                Arrays.asList("6.", "Wykład do wyboru - humanistyczny", "2", "Z", "15", "15", "-", "-", "-", "-"), // Ensure this is aligned
                Arrays.asList("RAZEM", "28", "-", "285", "105", "75", "105", "0", "0", "-")
        );


        for (int i = 0; i < 8; i++) {
            WebElement row = rows.get(i);


            List<WebElement> columns = row.findElements(By.tagName("td"));


            List<String> actualData = new ArrayList<>();
            for (WebElement column : columns) {
                actualData.add(column.getText().trim());
            }


            while (!actualData.isEmpty() && actualData.get(actualData.size() - 1).isEmpty()) {
                actualData.remove(actualData.size() - 1);
            }


            List<String> expectedRowData = expectedData.get(i);


            assertEquals(actualData, expectedRowData);
        }

        return new AiB();
    }

    public AiB assertAlertDoesNotAppear() throws InterruptedException {
        Thread.sleep(3000);
        assertFalse(alert.isDisplayed());

        return new AiB();
    }

    public AiB assertTitleOF2TermTable(){
        WaitForElement.waitForElementToBeVisible(tableOf2TermTitle);
        assertEquals("SEMESTR II",tableOf2TermTitle.getText())
        ;
        return new AiB();
    }

    public AiB assertSumOfECTS(){
        WaitForElement.waitForElementToBeVisible(tableRowSelector);
        double sum =0.0;
        for (int i = 10; i <= 17; i++) {
            String cellSelector = "#skrypt-wzr > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3)";
            WebElement cell = DriverManager.getDriver().findElement(By.cssSelector(cellSelector));
            sum += Double.parseDouble(cell.getText().replace(",", "").replaceAll("[^0-9.]", ""));
        }
        WebElement targetCell = DriverManager.getDriver().findElement(By.cssSelector("#skrypt-wzr > table > tbody > tr:nth-child(18) > td:nth-child(2)"));
        double expectedValue = Double.parseDouble(targetCell.getText().replace(",", "").replaceAll("[^0-9.]", ""));
//        System.out.println(sum);
        assertEquals(expectedValue,sum);
        return new AiB();
    }
    public AiB assertRozValues(){


        for (int i = 10; i <= 17; i++) {
            String cellXPath = "//*[@id='skrypt-wzr']/table/tbody/tr[" + i + "]/td[4]";
            WebElement cell = DriverManager.getDriver().findElement(By.xpath(cellXPath));


            String cellText = cell.getText().trim();


            assertTrue(cellText.equals("Z") || cellText.equals("E"));}


        return new AiB();
    }
    public AiB assertTotalValues(){
        WebElement dataRow = DriverManager.getDriver().findElement(By.xpath("//tr[td[contains(text(), 'ŁĄCZNIE')]]"));
        List<WebElement> columns = dataRow.findElements(By.xpath("./td[position() > 1]"));

        List<String> expectedValues = Arrays.asList("180", "-", "2030", "615", "420", "810", "65", "120", "-");
        List<String> actualValues = new ArrayList<>();

        for (WebElement column : columns) {
            actualValues.add(column.getText().trim());
        }
        assertEquals(expectedValues,actualValues);
        return new AiB();
    }

}
