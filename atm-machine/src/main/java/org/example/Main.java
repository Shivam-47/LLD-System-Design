package org.example;

import org.example.AtmCard.AtmCard;
import org.example.AtmMachine.AtmMachine;
import org.example.AtmState.AtmState;
import org.example.BankAccount.BankAccount;
import org.example.User.User;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to ATM Machine...!");

        try {
            BankAccount bankAccount = new BankAccount("12131", 2900);
            AtmCard atmCard = new AtmCard("C1213123", "12345", bankAccount);
            User user = new User("Shivam", bankAccount, atmCard);

            AtmMachine machine = new AtmMachine();

            getBalance(machine, user);
            withdrawMoney(machine, user, 1500);
            getBalance(machine, user);
            withdrawMoney(machine, user, 1000);
            getBalance(machine, user);
            withdrawMoney(machine, user, 200);
            getBalance(machine, user);

        } catch (Exception e){
            System.out.println("Exception occurred " + e);
        }

    }

    private static void getBalance(AtmMachine machine, User user) throws Exception {
        AtmState state = machine.getAtmState();
        state.insertCard(machine, user);

        state = machine.getAtmState();
        state.authenticatePin(machine, user, "12345");

        state = machine.getAtmState();
        state.selectOperation(machine, user, "check_balance");

        state = machine.getAtmState();
        state.checkBalance(machine, user);
    }

    private static void withdrawMoney(AtmMachine machine, User user, Integer amount) throws Exception {
        AtmState state = machine.getAtmState();
        state.insertCard(machine, user);

        state = machine.getAtmState();
        state.authenticatePin(machine, user, "12345");

        state = machine.getAtmState();
        state.selectOperation(machine, user, "withdraw");

        state = machine.getAtmState();
        state.cashWithdrawal(machine, user, amount);
    }
}