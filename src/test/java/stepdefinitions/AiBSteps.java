package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.pl.I;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.AiB;
import page.objects.AiBPDF;
import page.objects.StudyProgram;
import utils.URLS;

public class AiBSteps {

    StudyProgram studyProgram;
    AiB aiB;
    AiBPDF aiBPDF;

    @Zakładającże("jestem na stronie kierunku AiB")
    public void jestemNaStronieKierunkuAiB() throws InterruptedException {
        URLS.loadStudyProgramPage();
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
    public void otworzySieStronaZPDF() throws InterruptedException {
        aiBPDF.assertThatPageWithPDFIsOpened();
    }

    @I("ma 57 rzędów")
    public void ma57Rzedow(){
        aiB.assertNumberOfRows();
    }

    @I("ma okreslone nazwy kolumn")
    public void maOkresloneNazwyKolumn(){
        aiB.assertRowsWithColumnNames();
    }

    @I("klikne przycisk z plikiem PDF")
    public void kliknePrzyciskZPlikiemPDF(){
     aiBPDF = aiB.clickPDFButton();
    }

    @Wtedy("powinno się pojawić zdjęcię kierunku AiB")
    public void powinnoSięPojawićZdjęcięKierunkuAiB() {
        aiB.assertImage();
    }

    @Kiedy("kliknę przycisk wróć")
    public void kliknęPrzyciskWróć() {
        studyProgram = aiB.getBackToStudyPrograMPage();

    }

    @Wtedy("powinienem zostać przerzucony na poprzednią stronę")
    public void powinienemZostaćPrzerzuconyNaPoprzedniąStronę() throws InterruptedException {
        studyProgram.assertThatAiBTitleInsideIsNotVisible();
    }

    @Wtedy("Pojawi się tabela SEMESTR I")
    public void pojawiSięTabelaSEMESTRI() {
        aiB.assertTitleOF1TermTable();

    }

    @I("jest wypełniona odpowiednimi danymi")
    public void jestWypełnionaOdpowiednimiDanymi() {
        aiB.asserValuesOfRowsOF1TermTable();
    }

    @Wtedy("nie powinienem dostać alertu że program studiów na kierunku AiB nie został opublikowany")
    public void niePowinienemDostaćAlertuŻeProgramStudiówKaKierunkuAiBNieZostałOpublikowany() throws InterruptedException {
        aiB.assertAlertDoesNotAppear();
    }

    @Wtedy("Pojawi się tabela SEMESTR II")
    public void pojawiSięTabelaSEMESTRII() {
        aiB.assertTitleOF2TermTable();
    }

    @I("liczba ECTS'ów każdego przedmiotu się odpowiednio sumuje")
    public void liczbaECTSÓwKażdegoPrzedmiotuSięOdpowiednioSumuje() {
        aiB.assertSumOfECTS();
    }

    @I("kolumna Roz. ma wartosci zgodne z legenda \\(E lub Z)")
    public void kolumnaRozMaWartosciZgodneZLegendaELubZ() {
        aiB.assertRozValues();
    }

    @Wtedy("powinny się ukazać zsumowane wartosci dla wszystkich semestrow")
    public void powinnySięUkazaćZsumowaneWartosciDlaWszystkichSemestrow() {
        aiB.assertTotalValues();
    }
}
