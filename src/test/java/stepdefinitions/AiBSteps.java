package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.pl.I;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.AiB;
import page.objects.StudyProgram;

public class AiBSteps {

    StudyProgram studyProgram;
    AiB aiB;
    @Zakładającże("jestem na stronie kierunku AiB")
    public void jestemNaStronieKierunkuAiB() {
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia");
        studyProgram = new StudyProgram();
        StudyProgram.enterIframe();
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


    @I("ma 57 rzędów")
    public void numberOfRowsInTable(){
        aiB.assertNumberOfRows();
    }

}
