package page.objects;


import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;

public class PageObjectInitializer {
    public PageObjectInitializer() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}