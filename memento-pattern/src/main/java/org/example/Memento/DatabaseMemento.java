package org.example.Memento;

public class DatabaseMemento {
    private int numberOfShards;
    private String logsMode;

    public int getNumberOfShards() {
        return numberOfShards;
    }

    public String getLogsMode() {
        return logsMode;
    }

    public DatabaseMemento(int numberOfShards, String logsMode) {
        this.numberOfShards = numberOfShards;
        this.logsMode = logsMode;
    }
}
