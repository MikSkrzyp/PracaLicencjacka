package stepdefinitions;

import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import io.cucumber.java.an.E;
import io.cucumber.java.pl.I;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.AiB;
import page.objects.EconomicAnalytics;
import page.objects.StudyProgram;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class StudyProgramSteps {
    private StudyProgram studyProgram;
    private EconomicAnalytics economicAnalytics;
    private AiB aiB;

    @Zakładającże("Jestem na stronie z Programem Studiów")
    public void stronaProgramStudiow() throws InterruptedException {
        studyProgram = new StudyProgram();
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia");
        studyProgram.clickCookiesAlert();
    }

    @Zakładającże("Jestem na stronie z Programem Studiów AiB")
    public void aibPage(){
        DriverExtensions.navigateToPage("https://old.wzr.ug.edu.pl/wydzial/index2.php?str=1746&studies=1&specialty=50&field=0&mode=0&mode=1");
        aiB = new AiB();
    }

    @I("Zaznaczę opcję Studia Stacjonarne")
    public void analitykaGospodarczaStudiaStacjonarne() throws InterruptedException {
     economicAnalytics.clickBachelorCheckbox();
    }

    @I("Zaznaczę opcję Studia Stacjonarne na stronie AiB")
    public void AiBBachelorCheckbox() throws InterruptedException {
            aiB.clickBachelorCheckbox();
    }


    @Kiedy("Wybiorę kierunek Analityka Gospodarcza")
    public void analitykaGospodarcza() throws InterruptedException {
//        Thread.sleep(100000);
        economicAnalytics = studyProgram.clickOnAnalitykaGospodarczaLink();
    }


    @Kiedy("Wybiorę rok 2016-2017")
    public void aiBSelectDate20162017(){
        aiB.select20162017();
    }

    @Kiedy("Wybiorę kierunek AiB")
    public void AiB() throws InterruptedException {
        aiB = studyProgram.clickOnAiBLink();
    }





    @Wtedy("Powinienem zobaczyć tekst \"STUDIA I STOPNIA\"")
    public void assertTitle(){
        studyProgram.assertTitle();
    }

    @Wtedy("Nie powinien się pojawić przycisk z ikonką PDF")
    public void economicAnalyticsPDFICON() throws InterruptedException {
        economicAnalytics.assureThatPDFIconIsNotVisible();
    }

    @Wtedy("Powinienem zostać przeniesiony na stronę Analityki Gospodarczej")
    public void setDataScienceBPDFPage(){
        economicAnalytics.checkURL();
    }

    @Wtedy("Powinienem zobaczyć tablicę z przedmiotami kierunku AiB")
    public void tableOnAiBPage() throws InterruptedException {
        aiB.isTablePresent();
    }

    @Wtedy("zmieni się data")
    public void verifyDateChangeAiB(){
        aiB.verify20162017OnSelectButton();
    }

    @I("Zobaczyć komunikat: Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.")
    public void economicAnalyticsAlert(){
        economicAnalytics.checkAlert();
    }
}