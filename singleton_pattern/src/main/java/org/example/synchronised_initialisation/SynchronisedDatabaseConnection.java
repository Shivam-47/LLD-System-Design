package org.example.synchronised_initialisation;

public class SynchronisedDatabaseConnection {
    private static SynchronisedDatabaseConnection dbConnection;

    private String user;
    private String password;
    private SynchronisedDatabaseConnection() {
        this.user = "user"; //fetch from config
        this.password = "password"; //fetch from config
    }

    //synchronized makes this process expensive
    synchronized public static SynchronisedDatabaseConnection getConnection() {
        if (dbConnection == null){
            dbConnection = new SynchronisedDatabaseConnection();
        }
        return dbConnection;
    }
}
