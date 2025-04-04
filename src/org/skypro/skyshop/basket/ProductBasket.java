package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] storage = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < this.storage.length; i++) {
            if (this.storage[i] == null) {
                this.storage[i] = product;

                return;
            }
        }

//        throw new RuntimeException("Unable to add an item. Storage is full.");
        System.out.println("Невозможно добавить продукт");
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
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }

        if (hasProducts) {
            System.out.println("Итого: " + this.getTotalPrice());
        } else {
            System.out.println("в корзине пусто");
        }
    }

    public boolean hasProduct(String name) {
        for (Product product : this.storage) {
            if (product != null && name.equals(product.getName())) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        this.storage = new Product[this.storage.length];
    }
}
