package org.example.Iterator;

public interface Iterator <T> {
    boolean hasNext();
    T next() throws Exception;
}
