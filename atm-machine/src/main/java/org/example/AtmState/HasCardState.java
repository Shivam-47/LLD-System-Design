package org.example.AtmState;

import org.example.AtmMachine.AtmMachine;
import org.example.User.User;

public class HasCardState implements AtmState{
    @Override
    public void insertCard(AtmMachine machine, User user) throws Exception {
        throw new Exception("insertCard: not allowed for HasCard State");
    }

    @Override
    public void authenticatePin(AtmMachine machine, User user, String pin) throws Exception {
        Boolean isValidPin = user.getAtmCard().validatePing(pin);
        if (!isValidPin){
            machine.setAtmState(new IdleState());
            throw new Exception("INVALID PIN ENTERED");
        }

        machine.setAtmState(new AuthenticatedState());
    }

    @Override
    public void selectOperation(AtmMachine machine, User user, String operation) throws Exception {
        throw new Exception("selectOperation: not allowed for HasCard State");
    }

    @Override
    public void checkBalance(AtmMachine machine, User user) throws Exception {
        throw new Exception("checkBalance: not allowed for HasCard State");
    }

    @Override
    public void cashWithdrawal(AtmMachine machine, User user, Integer amount) throws Exception {
        throw new Exception("cashWithdrawal: not allowed for HasCard State");
    }

    @Override
    public void exit(AtmMachine machine, User user) throws Exception {
        machine.setAtmState(new IdleState());
    }
}
