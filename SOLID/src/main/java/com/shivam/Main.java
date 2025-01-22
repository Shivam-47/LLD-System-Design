package com.shivam;

import com.shivam.single_responsibility.Marker;
import com.shivam.single_responsibility.Invoice;
import com.shivam.single_responsibility.InvoiceCorrected;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println("Single responsibility");
        Marker marker = new Marker("my marker", "blue", 10);

        //initial code
        Invoice invoice = new Invoice(marker,2);
        System.out.println("invoice amount = " + invoice.calculateAmount());


        //corrected code
        InvoiceCorrected invoiceCorrected = new InvoiceCorrected(marker, 2);
        System.out.println("invoiceCorrected.calculateAmount() = " + invoiceCorrected.calculateAmount());
    }
}