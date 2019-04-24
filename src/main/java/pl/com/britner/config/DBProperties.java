package pl.com.britner.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {

    private static Properties getProperties() {
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
        return getProperties().getProperty("url");
    }

    public static String getPassword() {
        return getProperties().getProperty("password");
    }

    public static String getUser() {
        return getProperties().getProperty("user");
    }

    public static String getCustomerTableName() {
        return getProperties().getProperty("customer-table");
    }

    public static String getContactTableName() {
        return getProperties().getProperty("contact-table");
    }
}
