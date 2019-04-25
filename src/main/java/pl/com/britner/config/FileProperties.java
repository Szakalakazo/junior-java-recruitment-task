package pl.com.britner.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties {

    private static Properties getProperties() {
        String propertiesPath = "src/main/resources/file.properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesPath));
        } catch (IOException e) {
            System.out.println("No file.properties file found in src/main/resources/file.properties or incorrect file.properties content");
            e.printStackTrace();
        }
        return properties;
    }

    public static String getCSVFilePath() {
        return getProperties().getProperty("csv.file");
    }

    public static String getXMLFilePath() {
        return getProperties().getProperty("xml.file");
    }
}
