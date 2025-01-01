package utils;

import configurations.ConfigurationProperties;
import driver.manager.DriverExtensions;

public class URLS {
    public static void loadStudyProgramPage(){
        String url_studyprogram = ConfigurationProperties.getProperties().getProperty("url_studyprogram");
        DriverExtensions.navigateToPage(url_studyprogram);
    }
    public static void loadStaffPage(){
        String url_staff = ConfigurationProperties.getProperties().getProperty("url_staffpage");
        DriverExtensions.navigateToPage(url_staff);
    }
}
