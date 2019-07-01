package api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class apiConfigProvider {
    private Properties properties;
    public apiConfigProvider() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/setting.api.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String getProperty (String propertyName) {
        return properties.getProperty(propertyName);
    }
}
