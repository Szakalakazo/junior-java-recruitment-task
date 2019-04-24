package pl.com.britner.persistance;

import pl.com.britner.config.DBProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection myConnection;

    public Connection getMyConnection() {

        try {
            String url = DBProperties.getUrl();
            String password = DBProperties.getPassword();
            String user = DBProperties.getUser();

            myConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException exc) {
            System.out.println("Unable to create connection with DB.");
            exc.printStackTrace();
        }
        return myConnection;
    }
}