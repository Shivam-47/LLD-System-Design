package org.example.VendingMachine;

import org.example.Coin.Coin;
import org.example.Product.Product;

public class IdleState implements State {
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        System.out.println("Changing state to has-money state. Accepting money");
        machine.setState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("IdleState: insertCoin not allowed");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        throw new Exception("IdleState: clickOnSelectProductButton not allowed");
    }

    @Override
    public void chooseProduct(VendingMachine machine, Product product) throws Exception {
        throw new Exception("IdleState: chooseProduct not allowed");
    }

    @Override
    public Product dispatchProduct(VendingMachine machine,Product product) throws Exception {
        throw new Exception("IdleState: dispatchProduct not allowed");
    }

    @Override
    public void cancelProcess(VendingMachine machine) throws Exception {
        throw new Exception("IdleState: cancelProcess not allowed");
    }
}
