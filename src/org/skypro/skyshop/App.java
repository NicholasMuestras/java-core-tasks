package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        System.out.println("HW: 2");

        ProductBasket basket = new ProductBasket();
        // step 1
        basket.addProduct(new SimpleProduct("Spoon", 12));
        basket.addProduct(new SimpleProduct("Screwdriver", 100));
        basket.addProduct(new SimpleProduct("Cup", 5));
        basket.addProduct(new SimpleProduct("Lamp", 10));
        basket.addProduct(new SimpleProduct("Oil", 30));
        // step 2
        basket.addProduct(new SimpleProduct("Vodka", 6));
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

        System.out.println();
        System.out.println("HW: 3");

        basket.clear();
        basket.addProduct(new SimpleProduct("SimpleProduct-1", 2));
        basket.addProduct(new FixPriceProduct("SpecialProduct-1"));
        basket.addProduct(new DiscountedProduct("SpecialProduct-2", 100, 10));

        basket.printBasket();
    }
}
