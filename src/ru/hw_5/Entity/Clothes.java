package ru.hw_5.Entity;

/**
 * Created by admin on 21.11.2016.
 */
public class Clothes extends Product {
    private int size;

    public Clothes(String name, float price, int categoryID, int size,String imgPath) {
        super(name, price, categoryID,imgPath);
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Название: %s , стоимость: %s руб., id продукта: %s, размер: %s.\n",super.getName(),super.getPrice(),super.getId(),size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
