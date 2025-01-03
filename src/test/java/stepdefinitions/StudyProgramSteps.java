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
import utils.URLS;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class StudyProgramSteps {
    private StudyProgram studyProgram;
    private EconomicAnalytics economicAnalytics;
    private AiB aiB;
    private MasterStudies masterStudies;



    @Zakładającże("jestem na stronie z Programem Studiów I stopnia")
    public void jestemNaStronieZProgramemStudiow1Stopnia(){
        URLS.loadStudyProgramPage();
        studyProgram = new StudyProgram();

    }

    @Kiedy("wybiorę kierunek Analityka Gospodarcza")
    public void klikneAnalitykaGospodarcza() throws InterruptedException {
    studyProgram.enterIframe();
    economicAnalytics = studyProgram.clickEconomicAnalytics();
    }

    @Wtedy("ukaże mi się 17 kierunków studiów")
    public void ukazaMiSie17Kierunkow() throws InterruptedException {
        studyProgram.enterIframe();
        studyProgram.assertNumberOfCourses();
    }

    @Wtedy("ukaże mi się strona z programem studiów kierunku Analityki Gospodarczej")
    public void ukazeMiSieStronaZProgramemStudiowAnalitykiGospodarczej(){
        economicAnalytics.assertTitle();
    }


    @Kiedy("kliknę przycisk {string}")
    public void klinePrzycisk(String arg0) throws InterruptedException {
        studyProgram.clickAccessibilityButton();
    }

    @Wtedy("wyskoczy pop-up z ustawieniami dostępności")
    public void ukażaMiSięUstawieniaDostępnosci() throws InterruptedException {
        studyProgram.assertVisibilityOfAccessibilitySettings();
    }

    @Wtedy("powinienem zostać poinformowany o poprzednich koniecznych aby dojsc do aktualnej strony")
    public void powinienemZostaćPoinformowanyOPoprzednichPrzejsciachAbyDojscDoAktualnejStrony() {
        studyProgram.assertPath();
    }

    @Kiedy("wybiorę studia II stopnia w zakładce z poziomami studiów")
    public void wybioręStudiaIIStopniaWZakladceZPoziomamiStudiów() {
        masterStudies = studyProgram.goToMasterStudies();
    }

    @Wtedy("zostanę przeniesiony na odpowiednią stronę z kierunkami studiów II stopnia")
    public void zostanęPrzeniesionyNaOdpowiedniąStronę() {
        masterStudies.assertUrl();
    }

    @Wtedy("na stronie obecny jest domyślny nagłówek i stopka")
    public void naStronieJestWidocznyDomyslnyNagłówekIStopka() {
        studyProgram.assertVisibilityOfHeaderFooter();
    }

    @Wtedy("powinienem zobaczyć tekst {string}")
    public void powinienemZobaczyćTekst(String arg0) {
        studyProgram.assertTitle();
    }
}