package org.example.PaymentImplementation;

public class ImpsPaymentImplementation implements PaymentImplementation {
    @Override
    public void payAmount(double amount) {
        System.out.printf("Paying amount %f via IMPS\n", amount);
    }
}
