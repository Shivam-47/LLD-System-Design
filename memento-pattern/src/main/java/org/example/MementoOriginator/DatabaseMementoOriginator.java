package org.example.MementoOriginator;

import org.example.Memento.DatabaseMemento;

public interface DatabaseMementoOriginator {
    DatabaseMemento getCurrentMemento();
    void restoreToMemento(DatabaseMemento databaseMemento);
}
