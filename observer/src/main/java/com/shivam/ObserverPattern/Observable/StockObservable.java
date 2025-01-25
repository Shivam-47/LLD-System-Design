package com.shivam.ObserverPattern.Observable;

import com.shivam.ObserverPattern.Observer.NotificationObserver;

public interface StockObservable {
    public void addObserver(NotificationObserver observer);
    public void removeObserver(NotificationObserver observer);
    public void notifyObservers();
    public void setSKUStock(int skuStock);
    public int getSKUStock();

    public String getSkuName();
}
