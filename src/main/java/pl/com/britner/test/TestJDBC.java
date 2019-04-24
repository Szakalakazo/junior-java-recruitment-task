package pl.com.britner.test;

import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/customer?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "password";

        try {

            System.out.println("Connecting to DB" + url );

            DriverManager.getConnection(url, user, pass);

            System.out.println("Connection successful");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}