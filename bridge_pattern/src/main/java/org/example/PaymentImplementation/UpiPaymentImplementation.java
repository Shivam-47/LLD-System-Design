package org.example.PaymentImplementation;

public class UpiPaymentImplementation implements PaymentImplementation {
    @Override
    public void payAmount(double amount) {
        System.out.printf("Paying amount %f via UPI\n", amount);
    }
}
