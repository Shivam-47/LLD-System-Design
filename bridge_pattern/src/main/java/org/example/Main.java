package org.example;

import org.example.PaymentClient.HdfcPaymentClient;
import org.example.PaymentClient.KotakPaymentClient;
import org.example.PaymentClient.PaymentClient;
import org.example.PaymentClient.PaytmPaymentClient;
import org.example.PaymentImplementation.ImpsPaymentImplementation;
import org.example.PaymentImplementation.NeftPaymentImplementation;
import org.example.PaymentImplementation.PaymentImplementation;
import org.example.PaymentImplementation.UpiPaymentImplementation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to bridge pattern");

        PaymentImplementation neft = new NeftPaymentImplementation();
        PaymentClient hdfc = new HdfcPaymentClient(neft);
        hdfc.makePayment(100.0);

        PaymentImplementation imps = new ImpsPaymentImplementation();
        PaymentClient kotak = new KotakPaymentClient(imps);
        kotak.makePayment(200.0);

        PaymentImplementation upi =  new UpiPaymentImplementation();
        PaymentClient paytm = new PaytmPaymentClient(upi);
        paytm.makePayment(300.0);
    }
}