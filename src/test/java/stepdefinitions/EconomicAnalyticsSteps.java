package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.EconomicAnalytics;
import page.objects.StudyProgram;

public class EconomicAnalyticsSteps {
    EconomicAnalytics economicAnalytics;
    StudyProgram studyProgram;

    @Zakładającże("jestem na stronie kieurnku Analityka Gospodarcza")
    public void jestemNaStronieKieurnkuAnalitykaGospodarcza() throws InterruptedException {
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia");
        studyProgram = new StudyProgram();
        studyProgram.clickCookies();
        StudyProgram.enterIframe();
       economicAnalytics =  studyProgram.clickEconomicAnalytics();
    }

    @Kiedy("zaznacze przycisk studia stacjonarne")
    public void bachelorStudiesRadioClick(){
        economicAnalytics.clickBachelorRadio();
    }

    @Wtedy("Powinien sie ukazac przycisk z ikono pdf")
    public void pdfIcon() throws InterruptedException {
        economicAnalytics.assertVisibilityOfPdfIcon();
    }

}
