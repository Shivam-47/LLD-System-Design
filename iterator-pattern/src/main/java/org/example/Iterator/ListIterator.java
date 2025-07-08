package org.example.Iterator;

import org.example.Aggregator.ListAggregator;

import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {

    private ListAggregator<T> aggregator;
    private int currentIdx, prevIdx;

    public ListIterator(ListAggregator<T> aggregator) {
        this.aggregator = aggregator;
        this.currentIdx = 0;
        this.prevIdx = -1;
    }

    @Override
    public boolean hasNext() {
        return (this.currentIdx < aggregator.getSize());
    }

    @Override
    public T next() throws Exception {
        if(this.currentIdx >= aggregator.getSize()) {
            throw new NoSuchElementException();
        }

        T obj = this.aggregator.getList()[currentIdx];
        this.prevIdx = currentIdx;
        this.currentIdx++;
        return obj;
    }
}
