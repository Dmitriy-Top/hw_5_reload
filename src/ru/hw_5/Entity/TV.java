package ru.hw_5.Entity;

/**
 * Created by admin on 21.11.2016.
 */
public class TV extends Product {
    private float diagonal;

    public TV(String name, float price, int categoryID, float diagonal,String imgPath,int quantity) {
        super(name, price, categoryID,imgPath,quantity);
        this.diagonal = diagonal;
    }

    public float getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }
    @Override
    public String toString() {
        if (super.isOnCart())return String.format("Название: %s , стоимость: %.1f руб., id продукта: %s, диагональ: %s.\n",super.getName(),super.getPrice(),super.getId(),diagonal);
        return String.format("Название: %s , стоимость: %s руб., id продукта: %s, диагональ: %s, колличество: %s.\n",super.getName(),super.getPrice(),super.getId(),diagonal,super.getQuantityOnShop());
    }
}
