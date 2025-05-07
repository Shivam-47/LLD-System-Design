package org.example.AtmState;

import org.example.AtmMachine.AtmMachine;
import org.example.User.User;

import java.sql.SQLOutput;

public class IdleState implements AtmState{
    @Override
    public void insertCard(AtmMachine machine, User user) throws Exception {
        System.out.println("Machine accepted card successfully...");
        machine.setAtmState(new HasCardState());
    }

    @Override
    public void authenticatePin(AtmMachine machine, User user, String pin) throws Exception {
        throw new Exception("authenticatePin: not allowed for Idle State");
    }

    @Override
    public void selectOperation(AtmMachine machine, User user, String operation) throws Exception {
        throw new Exception("selectOperation: not allowed for Idle State");
    }

    @Override
    public void checkBalance(AtmMachine machine, User user) throws Exception {
        throw new Exception("checkBalance: not allowed for Idle State");
    }

    @Override
    public void cashWithdrawal(AtmMachine machine, User user, Integer amount) throws Exception {
        throw new Exception("cashWithdrawal: not allowed for Idle State");
    }

    @Override
    public void exit(AtmMachine machine, User user) throws Exception {
        throw new Exception("exit: not allowed for Idle State");
    }
}
