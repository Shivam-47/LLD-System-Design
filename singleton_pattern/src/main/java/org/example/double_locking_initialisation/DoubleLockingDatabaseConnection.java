package org.example.double_locking_initialisation;

public class DoubleLockingDatabaseConnection {
    private static DoubleLockingDatabaseConnection dbConnection;

    private String user;
    private String password;
    private DoubleLockingDatabaseConnection() {
        this.user = "user"; //fetch from config
        this.password = "password"; //fetch from config
    }


    public static DoubleLockingDatabaseConnection getConnection() {
        //both threads enter
        if (dbConnection == null){
            //only one executes this other waits
            synchronized (DoubleLockingDatabaseConnection.class){
                //first one inits
                //by the time second one reaches here the object is already created
                if(dbConnection == null){
                    dbConnection = new DoubleLockingDatabaseConnection();
                }
            }
        }
        return dbConnection;
    }
}
