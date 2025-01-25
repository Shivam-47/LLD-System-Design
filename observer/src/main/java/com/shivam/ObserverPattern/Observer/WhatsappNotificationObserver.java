package com.shivam.ObserverPattern.Observer;

import com.shivam.ObserverPattern.Observable.StockObservable;

public class WhatsappNotificationObserver implements NotificationObserver {

    private int phoneNumber;
    private final StockObservable stockObservable;

    public WhatsappNotificationObserver(int phoneNumber, StockObservable stockObservable){
        this.phoneNumber = phoneNumber;
        this.stockObservable = stockObservable;
    }

    public void update(){
        System.out.printf("Whatsapp Notification of SKU %s for stock: %d to phone-number: %d\n", stockObservable.getSkuName(), stockObservable.getSKUStock(), phoneNumber);
    }
}
