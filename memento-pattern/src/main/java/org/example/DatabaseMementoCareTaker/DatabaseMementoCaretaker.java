package org.example.DatabaseMementoCareTaker;

import org.example.Memento.DatabaseMemento;

public interface DatabaseMementoCaretaker {
    void saveMemento();
    void undoMemento();
    void restoreToMemento(DatabaseMemento databaseMemento);
    DatabaseMemento getCurrentMemento();
}
