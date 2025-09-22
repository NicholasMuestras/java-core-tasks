package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

import java.util.Objects;

abstract public class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Field 'name' must be not empty.");
        }

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

    @Override
    public boolean equals(Object article) {
        if (article == this) {
            return true;
        }

        if (!(article instanceof Searchable)) {
            return false;
        }

        return Objects.equals(this.getName(), ((Searchable) article).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
