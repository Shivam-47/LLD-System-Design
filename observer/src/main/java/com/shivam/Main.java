package com.shivam;

import com.shivam.ObserverPattern.Observable.IphoneObservableImpl;
import com.shivam.ObserverPattern.Observable.StockObservable;
import com.shivam.ObserverPattern.Observer.EmailNotificationObserver;
import com.shivam.ObserverPattern.Observer.NotificationObserver;
import com.shivam.ObserverPattern.Observer.WhatsappNotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world to Observable Pattern!");

        StockObservable iphoneStockObservable = new IphoneObservableImpl("Iphone 16");

        NotificationObserver emailNotificationObserver = new EmailNotificationObserver("user1@gmail.com", iphoneStockObservable);
        NotificationObserver secondEmailNotificationObserver = new EmailNotificationObserver("user2@gmail.com", iphoneStockObservable);

        NotificationObserver whatsappNotificationObserver = new WhatsappNotificationObserver(999999, iphoneStockObservable);


        iphoneStockObservable.addObserver(emailNotificationObserver);
        iphoneStockObservable.addObserver(secondEmailNotificationObserver);
        iphoneStockObservable.addObserver(whatsappNotificationObserver);

        System.out.println("Iphone stock is 10 now");
        iphoneStockObservable.setSKUStock(10);
        System.out.println("Iphone stock is 0 now");
        iphoneStockObservable.setSKUStock(0);

        iphoneStockObservable.removeObserver(emailNotificationObserver);

        System.out.println("Iphone stock is 5 now");
        iphoneStockObservable.setSKUStock(5);

        iphoneStockObservable.removeObserver(whatsappNotificationObserver);
        System.out.println("Iphone stock is 1 now");
        iphoneStockObservable.setSKUStock(1);
    }
}