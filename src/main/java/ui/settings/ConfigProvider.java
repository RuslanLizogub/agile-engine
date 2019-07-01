package ui.settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    private Properties properties;
    public ConfigProvider() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/setting.ui.properties"));
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
