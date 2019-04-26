package pl.com.britner.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {

    private static Properties getPropertiesFromFile() {
        String propertiesPath = "src/main/resources/db.properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesPath));
        } catch (IOException e) {
            System.out.println("No db.properties file found in src/main/resources/db.properties or incorrect db.properties content");
            e.printStackTrace();
        }
        return properties;
    }

    public static String getUrl() {
        return getPropertiesFromFile().getProperty("url");
    }

    public static String getPassword() {
        return getPropertiesFromFile().getProperty("password");
    }

    public static String getUser() {
        return getPropertiesFromFile().getProperty("user");
    }

    public static String getCustomerTableName() {
        return getPropertiesFromFile().getProperty("customer-table");
    }

    public static String getContactTableName() {
        return getPropertiesFromFile().getProperty("contact-table");
    }
}
