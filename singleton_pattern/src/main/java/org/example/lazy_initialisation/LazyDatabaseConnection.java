package org.example.lazy_initialisation;

import org.example.eager_initialisation.EagerDatabaseConnection;

public class LazyDatabaseConnection {
    private static LazyDatabaseConnection dbConnection;

    private String user;
    private String password;
    private LazyDatabaseConnection() {
        this.user = "user"; //fetch from config
        this.password = "password"; //fetch from config
    }

    public static LazyDatabaseConnection getConnection() {
        //not thread safe
        if (dbConnection == null){
            dbConnection = new LazyDatabaseConnection();
        }
        return dbConnection;
    }
}
