package pl.com.britner.dao;

import pl.com.britner.model.Contact;
import pl.com.britner.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO extends CommonDAO {


    public static void insertCustomer(List<Customer> customers) {
        for (Customer customer : customers) {

            try {
                String customerSql =
                        "INSERT INTO " + customerTableName + " (name, surname, age, city ) VALUES (?,?,?,?)";

                PreparedStatement ps =
                        dbConnection.getMyConnection().prepareStatement(customerSql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getSurname());
                ps.setInt(3, customer.getAge());
                ps.setString(4, customer.getCity());
                ps.execute();

                insertContact(customer, ps);

            } catch (SQLException exc) {
                System.out.println("Failed to insert customer to DB.");
                exc.printStackTrace();
            }
        }
    }

    private static void insertContact(Customer customer, PreparedStatement statement) throws SQLException {
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            customer.setId(generatedKeys.getLong(1));
        }

        List<Contact> contactList = customer.getContactList();

        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {

                String contactSql =
                        "INSERT INTO " + contactTableName + " (user_id, type, contact) VALUES (?,?,?)";
                PreparedStatement ps = dbConnection.getMyConnection().prepareStatement(contactSql);
                ps.setInt(1, Math.toIntExact(customer.getId()));
                ps.setInt(2, contact.getType());
                ps.setString(3, contact.getContact());
                ps.execute();
            }
        }
    }
}