package org.skypro.skyshop.product;

abstract public class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public int getPrice();

    abstract public boolean isSpecial();
}
