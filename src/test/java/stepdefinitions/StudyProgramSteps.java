package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.an.E;
import io.cucumber.java.pl.I;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.EconomicAnalytics;
import page.objects.StudyProgram;

import static org.testng.AssertJUnit.assertEquals;

public class StudyProgramSteps {
    private StudyProgram studyProgram;
    private EconomicAnalytics economicAnalytics;


    @Zakładającże("Jestem na stronie z Programem Studiów")
    public void stronaProgramStudiow() throws InterruptedException {
        studyProgram = new StudyProgram();
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia");
        studyProgram.clickCookiesAlert();
    }
    @Zakładającże("Jestem na stronie z Programem Studiów Analityki Gospodarczej")
    public void stronaProgramStudiowAnalitykaGospodarcza() throws InterruptedException {
        studyProgram = new StudyProgram();
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia");
       studyProgram.clickCookiesAlert();
        economicAnalytics = studyProgram.clickOnAnalitykaGospodarczaLink();

    }

    @Kiedy("Zaznaczę opcję Studia Stacjonarne")
    public void analitykaGospodarczaStudiaStacjonarne(){
     economicAnalytics.clickBachelorCheckbox();
    }


    @Kiedy("Wybiorę kierunek Analityka Gospodarcza")
    public void analitykaGospodarcza() throws InterruptedException {
//        Thread.sleep(100000);
        economicAnalytics = studyProgram.clickOnAnalitykaGospodarczaLink();
    }



    @Wtedy("Powinienem zobaczyć tekst \"STUDIA I STOPNIA\"")
    public void assertTitle(){
        studyProgram.assertTitle();
    }

    @Wtedy("Nie powinien się pojawić przycisk z ikonką PDF")
    public void economicAnalyticsPDFICON(){
        economicAnalytics.assureThatPDFIconIsNotVisible();
    }

    @Wtedy("Powinienem zostać przeniesiony na stronę Analityki Gospodarczej")
    public void setDataScienceBPDFPage(){
        economicAnalytics.checkURL();
    }

    @I("Zobaczyć komunikat: Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.")
    public void economicAnalyticsAlert(){
        economicAnalytics.checkAlert();
    }
}