package pl.com.britner.persistance;

import pl.com.britner.config.DBProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection myConnection;

    public Connection getMyConnection() {

        try {
            DBProperties dbProperties = new DBProperties();
            String url = dbProperties.getUrl(); //"jdbc:mysql://127.0.0.1:3306/customer?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String password = dbProperties.getPassword();//"password";//dbProperties.getPassword();
            String user = dbProperties.getUser();//"root";//dbProperties.getUser();

            myConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException exc) {
            System.out.println("Unable to create connection with DB.");
            exc.printStackTrace();
        }
        return myConnection;
    }
}