package org.example.CashWithdrawalChain;

import org.example.AtmMachine.AtmMachine;

public class FiveHundredDollarWithdrawalChain extends CashWithdrawalChain {

    public FiveHundredDollarWithdrawalChain(CashWithdrawalChain nextWithdrawalClass) {
        super(nextWithdrawalClass);
        this.value = 500;
    }

    @Override
    public void withdrawMoney(AtmMachine machine, Integer amount) throws Exception {
//        if(amount < 500){
//            this.nextWithdrawalClass.withdrawMoney(machine, amount);
//            return;
//        }
//
//        Integer balance = amount;
//        Integer has = machine.getInventory(500);
//        Integer required = amount/500;
//
//        if(required <= has){
//            System.out.printf("Withdrawing %d 500 bills\n", required);
//            machine.decrementInventory(500, required);
//            balance -= required*500;
//        } else {
//            System.out.printf("Withdrawing %d 500 bills\n", has);
//            machine.decrementInventory(500, has);
//            balance -= has*500;
//        }

        withdrawHelper(machine, amount);
    }
}
