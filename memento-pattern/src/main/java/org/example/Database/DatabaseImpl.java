package org.example.Database;

import org.example.Memento.DatabaseMemento;
import org.example.MementoOriginator.DatabaseMementoOriginator;

import java.util.*;

public class DatabaseImpl implements Database, DatabaseMementoOriginator {
    private int numberOfShards;
    private String logsMode;
    private Map<Integer, String> records;
    private static int idSequencer = 0;

    public DatabaseImpl(int numberOfShards, String logsMode) {
        this.numberOfShards = numberOfShards;
        this.logsMode = logsMode;
        this.records = new HashMap<>();
    }

    @Override
    public DatabaseMementoOriginator getOriginator() {
        return this;
    }

    @Override
    public int saveRecord(String record) {
        records.put(++idSequencer, record);
        return idSequencer;
    }

    @Override
    public String getRecord(int id) {
        return records.get(id);
    }

    @Override
    public DatabaseMemento getCurrentMemento() {
        return new DatabaseMemento(numberOfShards, logsMode);
    }

    @Override
    public void restoreToMemento(DatabaseMemento databaseMemento) {
        this.numberOfShards = databaseMemento.getNumberOfShards();
        this.logsMode = databaseMemento.getLogsMode();
    }

    @Override
    public void printCurrentConfig(){
        System.out.println("Current Database Configuration:");
        System.out.println("Number of Shards: " + numberOfShards);
        System.out.println("Logs Mode: " + logsMode);
        System.out.println("Records Count : " + records.size());
    }
}
