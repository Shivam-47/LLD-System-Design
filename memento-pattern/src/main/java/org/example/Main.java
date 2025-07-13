package org.example;

import org.example.Database.Database;
import org.example.Database.DatabaseImpl;
import org.example.DatabaseMementoCareTaker.DatabaseMementoCaretaker;
import org.example.DatabaseMementoCareTaker.DatabaseMementoCaretakerImpl;
import org.example.Memento.DatabaseMemento;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome to memento pattern!");

        Database myDatabase = new DatabaseImpl(2, "FULL");
        //client can still access the originator
        //todo fix this my making originator private inside database
        //use factory pattern to create database-caretaker and keep it in same package as originator
        DatabaseMementoCaretaker myDatabaseMementoCaretaker = new DatabaseMementoCaretakerImpl(myDatabase.getOriginator());

        int key1 = myDatabase.saveRecord("Record 1");
        int key2 = myDatabase.saveRecord("Record 2");

        myDatabase.getRecord(key1);
        myDatabase.getRecord(key2);
        myDatabaseMementoCaretaker.saveMemento();

        myDatabase.saveRecord("Record 3");
        myDatabase.printCurrentConfig();

        DatabaseMemento updatedMemento = new DatabaseMemento(5, "PARTIAL");
        myDatabaseMementoCaretaker.restoreToMemento(updatedMemento);
        myDatabase.printCurrentConfig();

        myDatabaseMementoCaretaker.undoMemento();
        myDatabase.printCurrentConfig();
    }
}