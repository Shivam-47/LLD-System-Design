package org.example.eager_initialisation;

public class EagerDatabaseConnection {
    private static EagerDatabaseConnection dbConnection = new EagerDatabaseConnection();

    private String user;
    private String password;
    private EagerDatabaseConnection() {
        this.user = "user"; //fetch from config
        this.password = "password"; //fetch from config
    }

    public static EagerDatabaseConnection getConnection() {
        return dbConnection;
    }
}
