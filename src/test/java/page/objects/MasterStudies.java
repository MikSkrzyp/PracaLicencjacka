package page.objects;

import driver.manager.DriverExtensions;
import io.cucumber.java.it.Ma;

import static org.testng.AssertJUnit.assertEquals;


public class MasterStudies extends PageObjectInitializer{

    public MasterStudies assertUrl(){
        assertEquals("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-ii-stopnia", DriverExtensions.getCurrentUrl());
        return new MasterStudies();
    }
}
