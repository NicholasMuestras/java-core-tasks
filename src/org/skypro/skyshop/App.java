package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        // step 1
        basket.addProduct(new Product("Spoon", 12));
        basket.addProduct(new Product("Screwdriver", 100));
        basket.addProduct(new Product("Cup", 5));
        basket.addProduct(new Product("Lamp", 10));
        basket.addProduct(new Product("Oil", 30));
        // step 2
        basket.addProduct(new Product("Vodka", 6));
        // step 3
        basket.printBasket();
        // step 4
        System.out.println(basket.getTotalPrice());
        // step 5
        System.out.println(basket.hasProduct("Screwdriver"));
        // step 6
        System.out.println(basket.hasProduct("Vodka"));
        // step 7
        basket.clear();
        // step 8
        basket.printBasket();
        // step 9
        basket.getTotalPrice();
        // step 10
        System.out.println(basket.hasProduct("Matryoshka"));
    }
}
