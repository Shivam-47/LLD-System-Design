package org.example.VendingMachine;

import org.example.Coin.Coin;
import org.example.Product.Product;

public class HasMoneyState implements State{
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("HasMoneyState: clickOnInsertCoinButton not allowed");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        machine.addInCoinQueue(coin);
        System.out.printf("Successfully inserted coin of value : %d\n", coin.getValue());
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        machine.setState(new ProductSelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine machine, Product product) throws Exception {
        throw new Exception("HasMoneyState: chooseProduct not allowed");
    }

    @Override
    public Product dispatchProduct(VendingMachine machine, Product product) throws Exception {
        throw new Exception("HasMoneyState: dispatchProduct not allowed");
    }

    @Override
    public void cancelProcess(VendingMachine machine) throws Exception {
        machine.setState(new IdleState());
        machine.emptyCoinQueue();
    }
}
