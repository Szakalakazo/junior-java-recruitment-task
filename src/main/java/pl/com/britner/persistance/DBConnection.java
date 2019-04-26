package pl.com.britner.persistance;

import pl.com.britner.config.DBProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection myConnection;

    private static void createConnection() {
        try {
            String url = DBProperties.getUrl();
            String password = DBProperties.getPassword();
            String user = DBProperties.getUser();
            myConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException exc) {
            System.out.println("Unable to create connection with DB.");
            System.out.println("SQL EXCEPTION: " + exc.getMessage());
        }
    }

    public static Connection getMyConnection(){
        if(myConnection == null) {
            createConnection();
        }
        return myConnection;
    }

    public static void closeConnection() {
        try {
            myConnection.close();
        } catch (SQLException e) {
            System.out.println("could not close connection");
            System.out.println("SQL state: " + e.getSQLState());
            e.printStackTrace();
        }
    }
}