package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

import java.util.Objects;

public class FixPriceProduct extends Product {

    private static final int PRICE = 50;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + ": Фиксированная цена " + this.getPrice();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (!(object instanceof Searchable)) {
            return false;
        }

        if (!(object instanceof FixPriceProduct)) {
            return false;
        }

        return Objects.equals(this.getName(), ((Searchable) object).getName()) && this.getPrice() == ((FixPriceProduct) object).getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName() + getPrice());
    }
}
