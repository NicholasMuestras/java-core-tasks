package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> storage = new LinkedList<>();

    public void addProduct(Product product) {
        this.storage.add(product);
    }

    public boolean hasProduct(String name) {
        for (Product product : this.storage) {
            if (product != null && name.equals(product.getName())) {
                return true;
            }
        }

        return false;
    }

    public List<Product> deleteProductsByName(String name) {
        Iterator<Product> iterator = this.storage.iterator();
        List<Product> removed = new LinkedList<>();

        while (iterator.hasNext()) {
            Product product = iterator.next();

            if (name.equals(product.getName())) {
                removed.add(product);
                this.storage.remove(product);
            }
        }

        return removed;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Product product : this.storage) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }

        return totalPrice;
    }

    public void printBasket() {
        boolean hasProducts = false;

        for (Product product : this.storage) {
            if (product != null) {
                hasProducts = true;
                System.out.println(product);
            }
        }

        if (hasProducts) {
            System.out.println("Итого: " + this.getTotalPrice());
            System.out.println("Специальных товаров: " + this.getSpecialProductCount());
        } else {
            System.out.println("в корзине пусто");
        }
    }

    private int getSpecialProductCount() {
        int count = 0;

        for (Product product : this.storage) {
            if (product != null && product.isSpecial()) {
                count++;
            }
        }

        return count;
    }

    public void clear() {
        this.storage = new LinkedList<>();
    }
}
