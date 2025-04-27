package org.example.Product;

import java.util.*;

public class ProductInventory {

    private Map<ProductShelf, Integer> inventoryMap;

    public ProductInventory() {
        this.inventoryMap = new HashMap<ProductShelf, Integer>();
    }

    public void addProduct(Product product, Integer quantity){

        for(Map.Entry<ProductShelf, Integer> entry: inventoryMap.entrySet()){
            ProductShelf shelf = entry.getKey();
            Integer value = entry.getValue();
            //existing item update quantity
            if (shelf.getProduct().getId() == product.getId()) {
                inventoryMap.put(shelf, value+quantity);
                return;
            }
        }

        //new item add to map
        ProductShelf shelf = new ProductShelf(product);
        inventoryMap.put(shelf, quantity);
    }

    public void removeProduct(Product product, Integer quantity) throws Exception {

        for(Map.Entry<ProductShelf, Integer> entry : inventoryMap.entrySet()){
            ProductShelf shelf = entry.getKey();
            Integer value = entry.getValue();

            if(Objects.equals(shelf.getProduct().getId(), product.getId())){

                if(value < quantity){
                    throw new Exception("Inventory Err: cannot remove more than stock value");
                }

                inventoryMap.put(shelf, value-quantity);
                return;
            }
        }

        throw new Exception("Inventory Err: product not found");
    }

    public Integer getInventoryOfProduct(Product product) {
        for(Map.Entry<ProductShelf, Integer> entry: inventoryMap.entrySet()){
            ProductShelf shelf = entry.getKey();
            Integer value = entry.getValue();

            if(Objects.equals(shelf.getProduct().getId(), product.getId())){
                return value;
            }
        }

        System.out.println("No inventory found for Product" + product.getName());
        return 0;
    }

    public List<Product> getAvailableProducts() {
        List<Product> productList = new ArrayList<Product>();

        for(Map.Entry<ProductShelf,Integer> entry: this.inventoryMap.entrySet()){
            ProductShelf productShelf = entry.getKey();
            Integer inventory = entry.getValue();

            if(inventory > 0)
                productList.add(productShelf.getProduct());
        }

        return productList;
    }
}
