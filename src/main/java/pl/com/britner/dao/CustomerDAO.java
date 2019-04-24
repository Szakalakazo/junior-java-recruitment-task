package pl.com.britner.dao;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO extends CommonDAO {

    public static void insertCustomer(Customer customer) {
        try {
            String customerSql = "INSERT INTO " + customerTableName + " (name, surname, age, city ) VALUES (?,?,?,?)";

            PreparedStatement myCustomerStmt = dbConnection.getMyConnection().prepareStatement(customerSql, Statement.RETURN_GENERATED_KEYS);
            myCustomerStmt.setString(1, customer.getName());
            myCustomerStmt.setString(2, customer.getSurname());
            myCustomerStmt.setInt(3, customer.getAge());
            myCustomerStmt.setString(4, customer.getCity());
            myCustomerStmt.execute();

            insertContact(customer, myCustomerStmt);

        } catch (SQLException exc) {
            System.out.println("Failed to insert customer to DB.");
            exc.printStackTrace();
        }
    }

    private static void insertContact(Customer customer, PreparedStatement myCustomerStmt) throws SQLException {
        ResultSet generatedKeys = myCustomerStmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            customer.setId(generatedKeys.getLong(1));
        }

        List<Contact> contactList = customer.getContactList();

        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {

                String contactSql = "INSERT INTO " + contactTableName + " (user_id, type, contact) VALUES (?,?,?)";
                PreparedStatement myContactStmt = dbConnection.getMyConnection().prepareStatement(contactSql);
                myContactStmt.setInt(1, Math.toIntExact(customer.getId()));
                myContactStmt.setInt(2, contact.getType());
                myContactStmt.setString(3, contact.getContact());
                myContactStmt.execute();
            }
        }
    }
}