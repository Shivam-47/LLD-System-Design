package org.example.VendingMachine;

import org.example.Coin.Coin;
import org.example.Product.Product;

public class ProductSelectionState implements State{
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
        throw new Exception("ProductSelectionState: clickOnInsertCoinButton not allowed");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        throw new Exception("ProductSelectionState: insertCoin not allowed");

    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception{
        throw new Exception("ProductSelectionState: clickOnSelectProductButton not allowed");

    }

    @Override
    public void chooseProduct(VendingMachine machine, Product product) throws Exception{
        //check price of product with coins inserted
        Integer totalAmountInMachine = machine.getCoinQueuePrice();
        if(product.getPrice() > totalAmountInMachine){
            throw new Exception(String.format("Price required for product %s is %d but you entered only %d", product.getName(), product.getPrice(), totalAmountInMachine));
        }

        //check balance
        Integer balance = totalAmountInMachine - product.getPrice();
        if (balance > 0)
            releaseBalanceAmount(balance);

        //check inventory of product
        Integer productInventory = machine.getInventoryOfProduct(product);
        if (productInventory == 0){
            throw new Exception(String.format("Uh Oh!, Seems like the product %s is not in stock! Initiating refund. Please select a different product", product.getName()));
        }

        machine.updateInventoryOfProduct(product, 1);

        //update state
        machine.setState(new DispatchProductState());
        machine.getState().dispatchProduct(machine, product);
    }

    @Override
    public Product dispatchProduct(VendingMachine machine,Product product) throws Exception{
        throw new Exception("ProductSelectionState: dispatchProduct not allowed");
    }

    @Override
    public void cancelProcess(VendingMachine machine) throws Exception{
        machine.setState(new IdleState());
        machine.emptyCoinQueue();
    }

    public void releaseBalanceAmount(Integer balance) {
        System.out.printf("ProductSelectionState: Here's the balance change of value %d\n",balance);
    }
}
