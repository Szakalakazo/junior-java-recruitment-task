package pl.com.britner.dao;

import pl.com.britner.persistance.DBConnection;

public class CommonDAO {

    static DBConnection dbConnection = new DBConnection();

    public DBConnection getDbConnection() {
        return dbConnection;
    }
}
