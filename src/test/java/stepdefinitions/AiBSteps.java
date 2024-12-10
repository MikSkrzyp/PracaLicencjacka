package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.pl.I;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.AiB;

public class AiBSteps {
    private AiB aiB;
    @Zakładającże("Jestem na stronie z Programem Studiów AiB")
    public void aibPage(){
        DriverExtensions.navigateToPage("https://old.wzr.ug.edu.pl/wydzial/index2.php?str=1746&studies=1&specialty=50&field=0&mode=0&mode=1");
        aiB = new AiB();
    }


    @Kiedy("Wybiorę rok 2016-2017")
    public void aiBSelectDate20162017(){
        aiB.select20162017();
    }
    @Kiedy("Zaznaczę opcję Studia Stacjonarne na stronie AiB")
    public void AiBBachelorCheckbox() throws InterruptedException {
        aiB.clickBachelorCheckbox();
    }


    @Wtedy("zmieni się data")
    public void verifyDateChangeAiB(){
        aiB.verify20162017OnSelectButton();
    }
    @Wtedy("Powinienem zobaczyć tablicę z przedmiotami kierunku AiB")
    public void tableOnAiBPage() throws InterruptedException {
        aiB.isTablePresent();
    }
}
