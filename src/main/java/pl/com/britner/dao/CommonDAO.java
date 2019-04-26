package pl.com.britner.dao;

import pl.com.britner.config.DBProperties;
import pl.com.britner.persistance.DBConnection;

import java.sql.Connection;

class CommonDAO {

    static Connection dbConnection = DBConnection.getMyConnection();
    static final String customerTableName = DBProperties.getCustomerTableName();
    static final String contactTableName = DBProperties.getContactTableName();
}
