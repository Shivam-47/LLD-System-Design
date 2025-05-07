package org.example.AtmCard;

import org.example.BankAccount.BankAccount;

public class AtmCard {

    public String getCardNumber() {
        return cardNumber;
    }

    public Boolean validatePing(String pin) {
        //abstraction keeping it simple for now
        return (pin.equals(pinHash));
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    private String cardNumber;
    private String pinHash;
    private BankAccount bankAccount;

    public AtmCard(String cardNumber, String pinHash, BankAccount bankAccount){
        this.cardNumber = cardNumber;
        this.pinHash = pinHash;
        this.bankAccount = bankAccount;
    }
}
