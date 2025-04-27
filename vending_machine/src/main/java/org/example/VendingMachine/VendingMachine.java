package org.example.VendingMachine;


import org.example.Coin.Coin;
import org.example.Ledger.Ledger;
import org.example.Ledger.Transaction;
import org.example.Product.Product;
import org.example.Product.ProductInventory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VendingMachine {

    private ProductInventory inventoryManager;
    private Queue<Coin> coinQueue;

    private Ledger transactionLedger;

    public Integer getCoinQueuePrice() {
        Integer totalAmount = 0;
        for(Coin coin: coinQueue){
            totalAmount += coin.getValue();
        }

        return totalAmount;
    }

    public void addInCoinQueue(Coin coin) {
        this.coinQueue.add(coin);
    }

    public void emptyCoinQueue() throws Exception {
        if(this.state instanceof HasMoneyState || this.state instanceof ProductSelectionState) {
            System.out.println("Emptying the coins queue");
            while(!this.coinQueue.isEmpty()){
                System.out.printf("Returning ...%d\n",coinQueue.poll().getValue());
            }
            System.out.println("Emptied the coins queue");
            return;
        }

        throw new Exception(String.format("emptyCoinQueue action not allowed for state %s", this.state.getClass().getSimpleName()));
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private State state;

    public VendingMachine(){
        this.inventoryManager = new ProductInventory();
        this.coinQueue = new LinkedList<Coin>();
        this.transactionLedger = new Ledger();
        this.state = new IdleState();
        initInventory();
    }

    public Integer getInventoryOfProduct(Product product){
        return this.inventoryManager.getInventoryOfProduct(product);
    }

    public void updateInventoryOfProduct(Product product, Integer quantity) throws Exception {
        if(this.state instanceof ProductSelectionState){
            this.inventoryManager.removeProduct(product, quantity);
            return;
        }

        throw new Exception(String.format("updateInventoryOfProduct action not allowed for state %s", this.state.getClass().getSimpleName()));
    }

    public void addTransactionToLedger(Integer amount) throws Exception{
        if(this.state instanceof DispatchProductState){
            this.transactionLedger.addTransaction(new Transaction(Transaction.TransactionType.CREDIT, amount));
            return;
        }

        throw new Exception(String.format("addTransactionToLedger action not allowed for state %s", this.state.getClass().getSimpleName()));
    }

    private void initInventory() {
        Product pepsi = new Product("PEPSI", "Pepsi can", 10);
        this.inventoryManager.addProduct(pepsi, 10);

        Product coke = new Product("Coke", "Coke can", 12);
        this.inventoryManager.addProduct(coke, 11);

        Product limca = new Product("Limca", "Limca can", 9);
        this.inventoryManager.addProduct(limca, 10);

        Product sprite = new Product("Sprite", "Sprite can", 10);
        this.inventoryManager.addProduct(sprite, 10);

        Product mountainDew = new Product("Mountain Dew", "Mountain Dew can", 8);
        this.inventoryManager.addProduct(mountainDew, 10);
    }

    public List<Product> getAvailableProducts(){
        List<Product> productList = this.inventoryManager.getAvailableProducts();

        for(Product product: productList){
            System.out.println("Product Name: " + product.getName());
        }

        return productList;
    }

    public void happyRun() throws Exception {
        System.out.println("Booting up machine!");

        List<Product> availableProducts = getAvailableProducts();

        this.state.clickOnInsertCoinButton(this);
        this.state.insertCoin(this, new Coin(Coin.CoinType.ONE));
        this.state.insertCoin(this, new Coin(Coin.CoinType.TEN));
        this.state.clickOnSelectProductButton(this);
        this.state.chooseProduct(this, availableProducts.get(0));
        System.out.println("Enjoy your product! Goodbye...");
    }
}
