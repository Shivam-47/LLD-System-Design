package com.shivam.ObserverPattern.Observable;

import com.shivam.ObserverPattern.Observer.NotificationObserver;
import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    private List<NotificationObserver> observerList = new ArrayList<>();
    private int stockCount;
    private String skuName;

    public IphoneObservableImpl(String skuName){
        this.skuName = skuName;
    }

    public void addObserver(NotificationObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for(NotificationObserver observer: observerList){
            observer.update();
        }
    }

    public void setSKUStock(int skuStock) {
        //fire notification on every change
        int currentStockCount = this.stockCount;
        this.stockCount = skuStock;

        if(skuStock != currentStockCount){
            notifyObservers();
        }
    }

    public int getSKUStock() {
        return this.stockCount;
    }

    public String getSkuName(){
        return this.skuName;
    }
}
