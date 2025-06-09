package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

abstract public class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public int getPrice();

    abstract public boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return this.getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
