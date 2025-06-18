package org.example.PaymentImplementation;

public class NeftPaymentImplementation implements PaymentImplementation {
    @Override
    public void payAmount(double amount) {
        System.out.printf("Paying amount %f via NEFT\n", amount);
    }
}
