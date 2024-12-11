package stepdefinitions;

import driver.manager.DriverExtensions;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.cucumber.java.pl.Zakładającże;
import page.objects.Staff;

public class StaffSteps {
    private Staff staff;
    @Zakładającże("jestem na stronie z pracownikami UG")
    public void jestemNaStronieZPracownikamiUG() {
        DriverExtensions.navigateToPage("https://wzr.ug.edu.pl/wydzial/pracownicy");
        staff = new Staff();
    }

    @Kiedy("klikne Dydaktycy")
    public void clickWladze(){
    Staff.enterIframe();
    staff.clickDydaktycyButton();
    }

    @Wtedy("pierwszy pracownik którego zobaczę to dr Alicja Antonowicz")
    public void drAlicjaAntoniwczName(){
        Staff.enterIframe();
        staff.assertDrAnotnowiczName();
    }

    @Wtedy("liczba pracowników na stronie powinna być równa 4")
    public void numberOfEmployeesEqualTo4() throws InterruptedException {
        staff.assertNumberOfEmployees();
    }

}
