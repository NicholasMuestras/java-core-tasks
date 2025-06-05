package org.skypro.skyshop.product;

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
}
