package org.example.PaymentClient;

import org.example.PaymentImplementation.PaymentImplementation;

public class PaytmPaymentClient extends PaymentClient {
    public PaytmPaymentClient(PaymentImplementation paymentImplementation) {
        super(paymentImplementation);
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paytm Payment Client");
        this.paymentImplementation.payAmount(amount);
    }
}
