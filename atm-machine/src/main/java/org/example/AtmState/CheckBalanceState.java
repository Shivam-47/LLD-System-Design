package org.example.AtmState;

import org.example.AtmMachine.AtmMachine;
import org.example.User.User;

public class CheckBalanceState implements AtmState{
    @Override
    public void insertCard(AtmMachine machine, User user) throws Exception {
        throw new Exception("insertCard: not allowed for CheckBalance State");
    }

    @Override
    public void authenticatePin(AtmMachine machine, User user, String pin) throws Exception {
        throw new Exception("authenticatePin: not allowed for CheckBalance State");
    }

    @Override
    public void selectOperation(AtmMachine machine, User user, String operation) throws Exception {
        throw new Exception("selectOperation: not allowed for CheckBalance State");
    }

    @Override
    public void checkBalance(AtmMachine machine, User user) throws Exception {
        Integer balance = user.getBankAccount().getBalance();
        System.out.printf("Your current account balance - %d\n", balance);
        machine.setAtmState(new IdleState());
        exit(machine, user);
    }

    @Override
    public void cashWithdrawal(AtmMachine machine, User user, Integer amount) throws Exception {
        throw new Exception("cashWithdrawal: not allowed for CheckBalance State");
    }

    @Override
    public void exit(AtmMachine machine, User user) throws Exception {
        System.out.printf("Please collect your card. Goodbye %s\n", user.getName());
    }
}
