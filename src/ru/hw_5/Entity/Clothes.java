package ru.hw_5.Entity;

/**
 * Created by admin on 21.11.2016.
 */
public class Clothes extends Product {
    private int size;

    public Clothes(String name, float price, int categoryID, int size,String imgPath,int quantity) {
        super(name, price, categoryID,imgPath,quantity);
        this.size = size;
    }

    @Override
    public String toString() {
        if (super.isOnCart())return String.format("Название: %s , стоимость: %.1f руб., id продукта: %s, размер: %s.\n",super.getName(),super.getPrice(),super.getId(),size);
        return String.format("Название: %s , стоимость: %s руб., id продукта: %s, размер: %s, колличество: %s.\n",super.getName(),super.getPrice(),super.getId(),size,super.getQuantityOnShop());
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
