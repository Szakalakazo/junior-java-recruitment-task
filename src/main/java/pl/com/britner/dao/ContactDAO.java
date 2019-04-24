package pl.com.britner.dao;

import pl.com.britner.model.Contact;

import java.sql.PreparedStatement;
import java.sql.SQLException;

class ContactDAO extends CommonDAO {

    public static void insertContact(Contact contact) {
        try {
            String sql = "INSERT INTO " + contactTableName + "(user_id, type, contact) VALUES (?,?,?)";
            PreparedStatement myStmt = dbConnection.getMyConnection().prepareStatement(sql);
            myStmt.setInt(1, Math.toIntExact(contact.getCustomerId()));
            myStmt.setInt(2, contact.getType());
            myStmt.setString(3, contact.getContact());
            myStmt.execute();

        } catch (SQLException exc) {
            System.out.println("Failed to insert contact to DB.");
            exc.printStackTrace();
        }
    }


}
