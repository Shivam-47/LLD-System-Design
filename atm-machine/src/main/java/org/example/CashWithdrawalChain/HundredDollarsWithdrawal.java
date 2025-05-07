package org.example.CashWithdrawalChain;

import org.example.AtmMachine.AtmMachine;

public class HundredDollarsWithdrawal extends CashWithdrawalChain {
    public HundredDollarsWithdrawal(CashWithdrawalChain nextWithdrawalClass) {
        super(nextWithdrawalClass);
        this.value = 100;
    }

    @Override
    public void withdrawMoney(AtmMachine machine, Integer amount) throws Exception {
//        if(amount < 100){
//            this.nextWithdrawalClass.withdrawMoney(machine, amount);
//            return;
//        }
//
//        Integer balance = amount;
//        Integer has = machine.getInventory(100);
//        Integer required = amount/100;
//
//        if(required <= has){
//            System.out.printf("Withdrawing %d 100$ bills\n", required);
//            machine.decrementInventory(100, required);
//            balance -= required*100;
//        } else {
//            System.out.printf("Withdrawing %d 100$ bills\n", has);
//            machine.decrementInventory(100, has);
//            balance -= has*100;
//        }
//
//        if(balance == 0){
//            return;
//        }

//        throw new Exception(String.format("unable to withdraw remaining balance amount %d", amount));

        withdrawHelper(machine, amount);
    }
}
