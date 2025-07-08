package org.example.Aggregator;

import org.example.Iterator.*;

import java.util.Arrays;

public class ListAggregator<T> implements Aggregator<T> {

    private T[] list;

    public ListAggregator(T[] list) {
        this.list = Arrays.copyOf(list, list.length);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ListIterator<>(this);
    }

    @Override
    public int getSize() {
        return this.list.length;
    }

    public T[] getList() {
        return this.list;
    }
}
