package org.example.VendingMachine;

import org.example.Coin.Coin;
import org.example.Product.Product;

public interface State {
    void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    void insertCoin(VendingMachine machine, Coin coin) throws Exception;

    void clickOnSelectProductButton(VendingMachine machine) throws Exception;
    void chooseProduct(VendingMachine machine, Product product) throws Exception;
//    void getBalance(Integer balance);
    Product dispatchProduct(VendingMachine machine, Product product) throws Exception;
    void cancelProcess(VendingMachine machine) throws Exception;

}
