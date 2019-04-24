package pl.com.britner.dao;

import pl.com.britner.model.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO extends CommonDAO {

    public static void insertCustomer(Customer customer) {
        try {
            String sql = "INSERT INTO customer (name, surname, age, city) VALUES (?,?,?,?)";
            PreparedStatement myStmt = dbConnection.getMyConnection().prepareStatement(sql);
            myStmt.setString(1, customer.getName());
            myStmt.setString(2, customer.getSurname());
            myStmt.setInt(3, customer.getAge());
            myStmt.setString(4, customer.getCity());
            myStmt.execute();

        } catch (SQLException exc) {
            System.out.println("Failed to insert customer to DB.");
            exc.printStackTrace();
        }
    }
}