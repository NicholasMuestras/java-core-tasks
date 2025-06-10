package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final int price;

    public SimpleProduct(String name, int price) throws IllegalArgumentException {
        super(name);

        if (price < 1) {
            throw new IllegalArgumentException("Field 'price' must be equal 1 or more");
        }

        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getPrice();
    }
}
