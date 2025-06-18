package org.example.PaymentClient;

import org.example.PaymentImplementation.PaymentImplementation;

public class HdfcPaymentClient extends PaymentClient {

    public HdfcPaymentClient(PaymentImplementation paymentImplementation) {
        super(paymentImplementation);
    }
    @Override
    public void makePayment(double amount) {
        System.out.println("HDFC Payment Client");
        this.paymentImplementation.payAmount(amount);
    }
}
