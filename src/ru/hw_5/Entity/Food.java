package ru.hw_5.Entity;

/**
 * Created by admin on 21.11.2016.
 */
public class Food extends Product {
    private float weight;
    public Food(String name, float price, int categoryID, float weight,String imgPath) {
        super(name, price, categoryID,imgPath);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return String.format("Название: %s , стоимость: %f руб., id продукта: %s, вес: %s.\n",super.getName(),super.getPrice(),super.getId(),weight);
    }
}
