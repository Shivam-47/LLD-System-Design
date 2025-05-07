package org.example.AtmState;

import org.example.AtmMachine.AtmMachine;
import org.example.User.User;

public class AuthenticatedState implements AtmState{
    @Override
    public void insertCard(AtmMachine machine, User user) throws Exception {
        throw new Exception("insertCard: not allowed for Authenticated State");
    }

    @Override
    public void authenticatePin(AtmMachine machine, User user, String pin) throws Exception {
        throw new Exception("authenticatePin: not allowed for Authenticated State");
    }

    @Override
    public void selectOperation(AtmMachine machine, User user, String operation) throws Exception {
        switch (operation){
            case "withdraw":
                machine.setAtmState(new CashWithdrawalState());
                return;
            case "check_balance":
                machine.setAtmState(new CheckBalanceState());
                return;
            default:
                throw new Exception("invalid operation passed");
        }
    }

    @Override
    public void checkBalance(AtmMachine machine, User user) throws Exception {
        throw new Exception("checkBalance: not allowed for Authenticated State");
    }

    @Override
    public void cashWithdrawal(AtmMachine machine, User user, Integer amount) throws Exception {
        throw new Exception("cashWithdrawal: not allowed for Authenticated State");
    }

    @Override
    public void exit(AtmMachine machine, User user) throws Exception {

    }
}
