package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int price;
    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);

        if (price < 1) {
            throw new IllegalArgumentException("Field 'price' must be equal 1 or more");
        }

        this.price = price;

        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Field 'discount' must be value from 0 to 100.");
        }

        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return price - (price / 100 * this.discount);
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getPrice() + " (" + this.getDiscount() + "%)";
    }
}
