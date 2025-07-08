package org.example.Aggregator;

import org.example.Iterator.Iterator;

public interface Aggregator <T> {
    Iterator<T> createIterator();
    int getSize();
}
