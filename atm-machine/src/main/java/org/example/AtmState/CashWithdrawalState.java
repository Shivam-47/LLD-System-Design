package org.example.AtmState;

import org.example.AtmMachine.AtmMachine;
import org.example.CashWithdrawalChain.CashWithdrawalChain;
import org.example.CashWithdrawalChain.FiveHundredDollarWithdrawalChain;
import org.example.CashWithdrawalChain.HundredDollarsWithdrawal;
import org.example.CashWithdrawalChain.ThousandDollarsWithdrawalChain;
import org.example.User.User;

public class CashWithdrawalState implements AtmState{
    @Override
    public void insertCard(AtmMachine machine, User user) throws Exception {
        throw new Exception("insertCard: not allowed for CashWithdrawal State");
    }

    @Override
    public void authenticatePin(AtmMachine machine, User user, String pin) throws Exception {
        throw new Exception("authenticatePin: not allowed for CashWithdrawal State");
    }

    @Override
    public void selectOperation(AtmMachine machine, User user, String operation) throws Exception {
        throw new Exception("selectOperation: not allowed for CashWithdrawal State");
    }

    @Override
    public void checkBalance(AtmMachine machine, User user) throws Exception {
        throw new Exception("checkBalance: not allowed for CashWithdrawal State");
    }

    @Override
    public void cashWithdrawal(AtmMachine machine, User user, Integer amount) throws Exception {
        //check account balance
        Integer accountBalance = user.getBankAccount().getBalance();
        if (amount > accountBalance) {
            throw new Exception(String.format("Cannot withdraw %d amount as balance is only %d", amount, accountBalance));
        }

        //check if check balance of machine
        Integer machineBalance = machine.getRemainingBalance();
        if (machineBalance < amount) {
            throw new Exception(String.format("Cannot withdraw %d amount as ATM balance is only %d", accountBalance, machineBalance));
        }

        //check if possible to withdraw balance
        if(!machine.possibleToWithdrawAmount(amount)){
            throw new Exception(String.format("Cannot withdraw %d amount as ATM does not have denomination for current value.", amount));
        }

        CashWithdrawalChain withdrawalChain = new ThousandDollarsWithdrawalChain(new FiveHundredDollarWithdrawalChain(new HundredDollarsWithdrawal(null)));

        //withdraw amount
        withdrawalChain.withdrawMoney(machine, amount);

        //update user balance
        user.getBankAccount().updateBalance(accountBalance-amount);

        //update machine state
        machine.setAtmState(new IdleState());
        exit(machine, user);
    }

    @Override
    public void exit(AtmMachine machine, User user) throws Exception {
        System.out.printf("Please collect your card. Goodbye %s\n", user.getName());
    }
}
