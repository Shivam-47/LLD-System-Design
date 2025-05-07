package org.example.User;

import org.example.AtmCard.AtmCard;
import org.example.BankAccount.BankAccount;

import java.util.UUID;

public class User {
    private String id;
    private String name;

    private BankAccount bankAccount;

    private AtmCard atmCard;

    public User(String name, BankAccount bankAccount, AtmCard atmCard){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.bankAccount = bankAccount;
        this.atmCard = atmCard;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public AtmCard getAtmCard() {
        return atmCard;
    }
}
