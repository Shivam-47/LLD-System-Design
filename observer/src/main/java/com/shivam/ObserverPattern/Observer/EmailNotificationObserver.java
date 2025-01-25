package com.shivam.ObserverPattern.Observer;

import com.shivam.ObserverPattern.Observable.StockObservable;

public class EmailNotificationObserver implements NotificationObserver {

    private final StockObservable stockObservable;
    private String email;
    public EmailNotificationObserver(String email, StockObservable stockObservable) {
        this.email = email;
        this.stockObservable = stockObservable;
    }

    public void updateObserver(){
        sendEmail();
    }

    private void sendEmail(){
        System.out.printf("Email Notification of SKU %s for stock %d to email: %s\n", stockObservable.getSkuName(), stockObservable.getSKUStock(), email);
    }
}
