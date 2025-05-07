package org.example.CashWithdrawalChain;

import org.example.AtmMachine.AtmMachine;

public abstract class CashWithdrawalChain {
    protected CashWithdrawalChain nextWithdrawalClass;
    protected Integer value;

    public CashWithdrawalChain(CashWithdrawalChain nextWithdrawalClass){
        this.nextWithdrawalClass = nextWithdrawalClass;
    }

    public void withdrawMoney(AtmMachine machine, Integer amount) throws Exception {
        if(this.nextWithdrawalClass != null){
            this.nextWithdrawalClass.withdrawMoney(machine,amount);
        } else {
            throw new Exception(String.format("unable to withdraw amount. please enter a small amount"));
        }
    }

    protected void withdrawHelper(AtmMachine machine, Integer amount) throws Exception {
        if(amount < value){
            this.nextWithdrawalClass.withdrawMoney(machine, amount);
            return;
        }

        Integer balance = amount;
        Integer has = machine.getInventory(value);
        Integer required = amount/value;

        if(required <= has){
            System.out.printf("Withdrawing %d %d bills\n", required, value);
            machine.decrementInventory(value, required);
            balance -= required*value;
        } else {
            System.out.printf("Withdrawing %d %d bills\n", has, value);
            machine.decrementInventory(value, has);
            balance -= has*value;
        }

        if(balance > 0){
            nextWithdrawalClass.withdrawMoney(machine,balance);
        }
    }
}
