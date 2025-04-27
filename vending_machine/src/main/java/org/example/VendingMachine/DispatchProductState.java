package org.example.VendingMachine;

import org.example.Coin.Coin;
import org.example.Product.Product;

public class DispatchProductState implements State{
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("DispatchProductState: clickOnInsertCoinButton not allowed");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        throw new Exception("DispatchProductState: insertCoin not allowed");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception{
        throw new Exception("DispatchProductState: clickOnSelectProductButton not allowed");
    }

    @Override
    public void chooseProduct(VendingMachine machine, Product product) throws Exception{
        throw new Exception("DispatchProductState: chooseProduct not allowed");

    }

    @Override
    public Product dispatchProduct(VendingMachine machine, Product product) throws Exception{
        System.out.printf("Please wait. Dispatching product %s....\n", product.getName());

        //add transactions
        machine.addTransactionToLedger(product.getPrice());
        machine.setState(new IdleState());
        return product;
    }

    @Override
    public void cancelProcess(VendingMachine machine) throws Exception{
        throw new Exception("DispatchProductState: cancelProcess not allowed");
    }
}
