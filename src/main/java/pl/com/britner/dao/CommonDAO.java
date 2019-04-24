package pl.com.britner.dao;

import pl.com.britner.config.DBProperties;
import pl.com.britner.persistance.DBConnection;

class CommonDAO {

    static final DBConnection dbConnection = new DBConnection();

    static final String customerTableName = DBProperties.getCustomerTableName();
    static final String contactTableName = DBProperties.getContactTableName();

    public DBConnection getDbConnection() {
        return dbConnection;
    }
}
