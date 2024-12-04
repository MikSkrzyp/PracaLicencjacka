package configurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyLoader {

    public Properties loadPropertiesFromFile(String fileName) {
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new IllegalArgumentException("Configuration file '" + fileName + "' not found.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration file '" + fileName + "'.", e);
        }

        return properties;
    }
}