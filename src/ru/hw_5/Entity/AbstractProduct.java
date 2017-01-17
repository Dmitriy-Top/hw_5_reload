package ru.hw_5.Entity;

/**
 * Created by admin on 21.11.2016.
 */
public class AbstractProduct {
    private int quantityOnShop;
    private int quantityOnCart;

    public AbstractProduct(int quantity) {
        this.quantityOnShop = quantity;
    }

    public int getQuantityOnShop() {
        return quantityOnShop;
    }

    public void setQuantityOnShop(int quantityOnShop) {
        this.quantityOnShop = quantityOnShop;
    }

    public int getQuantityOnCart() {
        return quantityOnCart;
    }

    public void setQuantityOnCart(int quantityOnCart) {
        this.quantityOnCart = quantityOnCart;
    }
}
