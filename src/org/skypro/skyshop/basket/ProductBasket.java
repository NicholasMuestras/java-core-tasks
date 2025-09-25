package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        return this.storage.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        this.storage.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

        if (this.storage.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + this.getTotalPrice());
            System.out.println("Специальных товаров: " + this.getSpecialProductCount());
        }
    }

    private int getSpecialProductCount() {
        return (int) this.storage.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    public void clear() {
        this.storage = new HashMap<>();
    }
}
