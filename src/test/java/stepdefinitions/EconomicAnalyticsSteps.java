package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.EconomicAnalytics;
import page.objects.StudyProgram;
import utils.URLS;

public class EconomicAnalyticsSteps {
    EconomicAnalytics economicAnalytics;
    StudyProgram studyProgram;

    @Zakładającże("jestem na stronie kieurnku Analityka Gospodarcza")
    public void jestemNaStronieKieurnkuAnalitykaGospodarcza() throws InterruptedException {
        URLS.loadStudyProgramPage();
        studyProgram = new StudyProgram();
        studyProgram.enterIframe();
        economicAnalytics =  studyProgram.clickEconomicAnalytics();

    }

    @Kiedy("zaznacze przycisk studia stacjonarne")
    public void zaznaczePrzyciskStudiaStacjonarne() {
        economicAnalytics.clickBachelorRadio();
    }

    @Wtedy("Nie powinien sie ukazac przycisk z ikonką pdf")
    public void niePowinienSieUkazacPrzyciskZIkonkaPDF() throws InterruptedException {
        economicAnalytics.assertVisibilityOfPdfIcon();
    }

    @Wtedy("powinna się ukazać wiadomosc: Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.")
    public void powinnaSieUkazacWiadomoscProgramStudiowDlaSpecjalnosciAnalitykaGospodarczaNaRokAkademicki20242025NieZostalOpublikowany(){
        economicAnalytics.alertThatProgramWasNotPublished();
    }

    @Kiedy("wybiorę rok {string} przy przycisku {string}")
    public void wybioręRokPrzyPrzycisku(String arg0, String arg1) {
        economicAnalytics.select20162017();

    }

    @Wtedy("wartosc sie zmieni na {string}")
    public void wartoscSieZmieniNa(String arg0) {
        economicAnalytics.assertSelectValue();
    }
}
