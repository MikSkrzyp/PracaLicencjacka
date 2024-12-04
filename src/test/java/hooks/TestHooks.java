
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import configurations.PropertyLoader;
import configurations.ConfigurationProperties;
import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import driver.browser.BrowserTypes;

import java.util.Properties;

public class TestHooks {

    @Before(order = 0)
    public void loadProperties() {
        PropertyLoader propertyLoader = new PropertyLoader();
        Properties properties = propertyLoader.loadPropertiesFromFile("configurations.properties");
        ConfigurationProperties.setProperties(properties);
    }

    @Before(order = 1)
    public void setupDriver(Scenario scenario) {
        String browser = ConfigurationProperties.getProperties().getProperty("browser"); // Default browser is Chrome

        // Check for browser tag in the scenario
        if (scenario.getSourceTagNames().contains("@firefox")) {
            browser = "FIREFOX";
        } else if (scenario.getSourceTagNames().contains("@chrome")) {
            browser = "CHROME";
        } else if (scenario.getSourceTagNames().contains("@edge")) {
            browser = "EDGE";
        }

        String baseUrl = ConfigurationProperties.getProperties().getProperty("url");
        DriverManager.setDriver(BrowserTypes.valueOf(browser));

        DriverExtensions.maximizeWindow();
        DriverExtensions.navigateToPage(baseUrl);

        System.out.println("Running Scenario: " + scenario.getName() + " on browser: " + browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.err.println("Scenario failed: " + scenario.getName());
        }
        DriverManager.quitDriver();
    }
}