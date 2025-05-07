package org.example.CashWithdrawalChain;

import org.example.AtmMachine.AtmMachine;

public class ThousandDollarsWithdrawalChain extends CashWithdrawalChain {
    public ThousandDollarsWithdrawalChain(CashWithdrawalChain nextWithdrawalClass) {
        super(nextWithdrawalClass);
        this.value = 1000;
    }

    @Override
    public void withdrawMoney(AtmMachine machine, Integer amount) throws Exception {
//        if(amount < 1000){
//            this.nextWithdrawalClass.withdrawMoney(machine, amount);
//            return;
//        }
//
//        Integer balance = amount;
//        Integer has = machine.getInventory(1000);
//        Integer required = amount/1000;
//
//        if(required <= has){
//            System.out.printf("Withdrawing %d 1000$ bills\n", required);
//            machine.decrementInventory(1000, required);
//            balance -= required*1000;
//        } else {
//            System.out.printf("Withdrawing %d 1000$ bills\n", has);
//            machine.decrementInventory(1000, has);
//            balance -= has*1000;
//        }
//
//        if(balance > 0){
//            nextWithdrawalClass.withdrawMoney(machine,balance);
//        }

        withdrawHelper(machine, amount);
    }
}
