package org.example.PaymentClient;

import org.example.PaymentImplementation.PaymentImplementation;

public abstract class PaymentClient {
    protected PaymentImplementation paymentImplementation;

    public PaymentClient(PaymentImplementation paymentImplementation) {
        this.paymentImplementation = paymentImplementation;
    }

    abstract public void makePayment(double amount);
}
