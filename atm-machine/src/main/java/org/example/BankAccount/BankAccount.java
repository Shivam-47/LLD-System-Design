package org.example.BankAccount;

public class BankAccount {

    private Integer balance;
    private String number;

    public Integer getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public BankAccount(String number, Integer balance){
        this.number = number;
        this.balance = balance;
    }

    public void updateBalance(Integer amount){
        this.balance = amount;
    }
}
