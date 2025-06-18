package org.example.PaymentClient;

import org.example.PaymentImplementation.PaymentImplementation;

public class KotakPaymentClient extends PaymentClient{

    public KotakPaymentClient(PaymentImplementation paymentImplementation) {
        super(paymentImplementation);
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Kotak Payment Client");
        this.paymentImplementation.payAmount(amount);
    }
}
