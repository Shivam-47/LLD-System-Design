package org.example.DatabaseMementoCareTaker;

import org.example.Memento.DatabaseMemento;
import org.example.MementoOriginator.DatabaseMementoOriginator;

import java.util.*;

public class DatabaseMementoCaretakerImpl implements DatabaseMementoCaretaker {

    private List<DatabaseMemento> history;
    private DatabaseMementoOriginator originator;

    public DatabaseMementoCaretakerImpl(DatabaseMementoOriginator originator) {
        this.history = new ArrayList<DatabaseMemento>();
        this.originator = originator;
    }

    @Override
    public void restoreToMemento(DatabaseMemento databaseMemento) {
        this.originator.restoreToMemento(databaseMemento);
    }

    @Override
    public void saveMemento() {
        DatabaseMemento memento = originator.getCurrentMemento();
        history.add(memento);
        System.out.println("Memento saved: " + memento);
    }

    @Override
    public void undoMemento() {
        if (history.isEmpty()) {
            System.out.println("No mementos to restore.");
            return;
        }

        DatabaseMemento memento = history.get(history.size() - 1);
        originator.restoreToMemento(memento);
        history.remove(history.size() - 1);
        System.out.println("Memento restored: " + memento);
    }

    @Override
    public DatabaseMemento getCurrentMemento() {
        if (history.isEmpty()) {
            return null;
        }
        return history.get(history.size() - 1);
    }
}
