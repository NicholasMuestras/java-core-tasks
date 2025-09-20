package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private Map<String, List<Product>> storage = new HashMap<>();

    public void addProduct(Product product) {
        List<Product> setOfProducts;

        if (this.storage.containsKey(product.getName())) {
            setOfProducts = this.storage.get(product.getName());
        } else {
            setOfProducts = new LinkedList<>();
        }

        setOfProducts.add(product);
        this.storage.put(product.getName(), setOfProducts);
    }

    public boolean hasProduct(String name) {
        return this.storage.containsKey(name);
    }

    public List<Product> deleteProductsByName(String name) {
        List<Product> removed;

        if (this.hasProduct(name)) {
            removed = this.storage.get(name);
            this.storage.remove(name);
        } else {
            removed = new LinkedList<>();
        }

        return removed;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (List<Product> setOfProducts : this.storage.values()) {
            for (Product product : setOfProducts) {
                if (product != null) {
                    totalPrice += product.getPrice();
                }
            }
        }

        return totalPrice;
    }

    public void printBasket() {
        for (List<Product> setOfProducts : this.storage.values()) {
            for (Product product : setOfProducts) {
                if (product != null) {
                    System.out.println(product);
                }
            }
        }

        if (this.storage.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + this.getTotalPrice());
            System.out.println("Специальных товаров: " + this.getSpecialProductCount());
        }
    }

    private int getSpecialProductCount() {
        int count = 0;

        for (List<Product> setOfProducts : this.storage.values()) {
            for (Product product : setOfProducts) {
                if (product != null && product.isSpecial()) {
                    count++;
                }
            }
        }

        return count;
    }

    public void clear() {
        this.storage = new HashMap<>();
    }
}
