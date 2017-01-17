package ru.hw_5.Entity;

/**
 * Created by admin on 21.11.2016.
 */
public class Food extends Product {
    private float weight;
    public Food(String name, float price, int categoryID, float weight,String imgPath,int quantity) {
        super(name, price, categoryID,imgPath,quantity);
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
        if (super.isOnCart())return String.format("Название: %s , стоимость: %.1f руб., id продукта: %s, вес: %s.\n",super.getName(),super.getPrice(),super.getId(),weight);
        return String.format("Название: %s , стоимость: %f руб., id продукта: %s, вес: %s, колличество: %s\n",super.getName(),super.getPrice(),super.getId(),weight,super.getQuantityOnShop());
    }
}
