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
import page.objects.MasterStudies;
import page.objects.StudyProgram;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class StudyProgramSteps {
    private StudyProgram studyProgram;
    private EconomicAnalytics economicAnalytics;
    private AiB aiB;
    private MasterStudies masterStudies;



    @Zakładającże("jestem na stronie z Programem Studiów 1 stopnia")
    public void bachelorStudiesPage(){
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia");
        studyProgram = new StudyProgram();

    }

    @Kiedy("klikne Analityka Gospodarcza")
    public void clickEconomicAnalytics() throws InterruptedException {
    studyProgram.enterIframe();
    economicAnalytics = studyProgram.clickEconomicAnalytics();
    }

    @Wtedy("ukażę mi się 17 kierunków")
    public void seventeenCourses() throws InterruptedException {
        studyProgram.enterIframe();
        studyProgram.assertNumberOfCourses();
    }


    @Wtedy("Powinienem zobaczyć tekst \"STUDIA I STOPNIA\"")
    public void assertTitle(){
        studyProgram.assertTitle();
    }



    @Wtedy("ukaze mi sie strona z programem studiow Analityki Gospodarczej")
    public void pageWithEconomicAnalytics(){
        economicAnalytics.assertTitle();
    }


    @Kiedy("kline przycisk {string}")
    public void klinePrzycisk(String arg0) throws InterruptedException {
        studyProgram.clickAccessibilityButton();
    }

    @Wtedy("ukaża mi się ustawienia dostępnosci")
    public void ukażaMiSięUstawieniaDostępnosci() throws InterruptedException {
        studyProgram.assertVisibilityOfAccessibilitySettings();
    }

    @Wtedy("powinienem zostać poinformowany o poprzednich przejsciach aby dojsc do aktualnej strony")
    public void powinienemZostaćPoinformowanyOPoprzednichPrzejsciachAbyDojscDoAktualnejStrony() {
        studyProgram.assertPath();
    }

    @Kiedy("wybiorę studia II stopnia w zakladce z poziomami studiów")
    public void wybioręStudiaIIStopniaWZakladceZPoziomamiStudiów() {
        masterStudies = studyProgram.goToMasterStudies();
    }

    @Wtedy("zostanę przeniesiony na odpowiednią stronę")
    public void zostanęPrzeniesionyNaOdpowiedniąStronę() {
        masterStudies.assertUrl();
    }
}