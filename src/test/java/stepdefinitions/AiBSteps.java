package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.pl.I;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.AiB;
import page.objects.AiBPDF;
import page.objects.StudyProgram;

public class AiBSteps {

    StudyProgram studyProgram;
    AiB aiB;
    AiBPDF aiBPDF;

    @Zakładającże("jestem na stronie kierunku AiB")
    public void jestemNaStronieKierunkuAiB() throws InterruptedException {
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia");
        studyProgram = new StudyProgram();
        studyProgram.enterIframe();
        aiB =  studyProgram.clickAiB();
    }

    @Kiedy("zaznacze przycisk studia stacjonarne kierunku AiB")
    public void zaznaczePrzyciskStudiaStacjonarneKierunkuAiB() {
        aiB.clickBachelorRadio();
    }

    @Wtedy("Pojawi się tabela")
    public void pojawiSięTabela() {
        aiB.assertTableIsPresent();
    }


    @Wtedy("otworzy się strona z PDF")
    public void pdfPage() throws InterruptedException {
        aiBPDF.assertThatPageWithPDFIsOpened();
    }

    @I("ma 57 rzędów")
    public void numberOfRowsInTable(){
        aiB.assertNumberOfRows();
    }

    @I("ma okreslone nazwy kolumn")
    public void columnNames(){
        aiB.assertRowsWithColumnNames();
    }

    @I("klikne przycisk z plikiem PDF")
    public void clickAiBPDF(){
     aiBPDF = aiB.clickPDFButton();
    }
}
