package org.example.AtmState;

import org.example.AtmMachine.AtmMachine;
import org.example.User.User;

public interface AtmState {
    void insertCard(AtmMachine machine, User user) throws Exception;
    void authenticatePin(AtmMachine machine, User user, String pin) throws Exception;
    void selectOperation(AtmMachine machine, User user, String operation) throws Exception;
    void checkBalance(AtmMachine machine, User user) throws Exception;
    void cashWithdrawal(AtmMachine machine, User user, Integer amount) throws Exception;
    void exit(AtmMachine machine, User user) throws Exception;
}
