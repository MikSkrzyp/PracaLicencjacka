package page.objects;

import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

public class AiBPDF extends PageObjectInitializer{


    public AiBPDF assertThatPageWithPDFIsOpened() throws InterruptedException {

        Thread.sleep(3000);


        ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
        if (tabs.size() > 1) {

            DriverManager.getDriver().switchTo().window(tabs.get(1));
            assertEquals("https://old.wzr.ug.edu.pl/.pdf/programy.php?st=1&spec=50&tr=1&lata=2024-2025&lang=pl", DriverExtensions.getCurrentUrl());
            DriverManager.getDriver().close();
            DriverManager.getDriver().switchTo().window(tabs.get(0));
        } else {

            String pdfEmbedUrl = DriverManager.getDriver().findElement(By.tagName("embed")).getAttribute("original-url");
            assertEquals("https://old.wzr.ug.edu.pl/.pdf/programy.php?st=1&spec=50&tr=1&lata=2024-2025&lang=pl", pdfEmbedUrl);
        }

        return new AiBPDF();
    }

}
