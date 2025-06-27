package org.example;

import org.example.eager_initialisation.EagerDatabaseConnection;
import org.example.lazy_initialisation.LazyDatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EagerDatabaseConnection eagerConn =  EagerDatabaseConnection.getConnection();
        LazyDatabaseConnection lazyConn = LazyDatabaseConnection.getConnection();
    }
}