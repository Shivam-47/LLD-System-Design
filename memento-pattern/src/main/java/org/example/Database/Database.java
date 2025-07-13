package org.example.Database;

import org.example.MementoOriginator.DatabaseMementoOriginator;

public interface Database {
    int saveRecord(String record);
    String getRecord(int id);
    DatabaseMementoOriginator getOriginator();
    void printCurrentConfig();
}
