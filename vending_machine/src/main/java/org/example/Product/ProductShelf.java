package org.example.Product;

import java.util.Random;

public class ProductShelf {
    private String code;


    public String getCode() {
        return code;
    }

    public Product getProduct() {
        return product;
    }

    private Product product;

    private static String getRandomThreeDigitNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100; // Generates a number between 100 (inclusive) and 999 (inclusive)
        return String.valueOf(randomNumber);
    }

    public ProductShelf(Product product){
        this.code = getRandomThreeDigitNumber();
        this.product = product;
    }
}
