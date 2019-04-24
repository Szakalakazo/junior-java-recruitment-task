package pl.com.britner.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {

    private Properties getProperties() {
        String fullPath = "src/main/resources/db.properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(fullPath));
        } catch (IOException e) {
            System.out.println("No db.properties file found in /webapp/config/ OR WRONG db.properties CONTENT");
            e.printStackTrace();
        }
        return properties;
    }

    public String getUrl() {
        return getProperties().getProperty("url");
    }

    public String getPassword() {
        return getProperties().getProperty("password");
    }

    public String getUser() {
        return getProperties().getProperty("user");
    }
}
