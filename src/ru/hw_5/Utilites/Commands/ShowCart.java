package ru.hw_5.Utilites.Commands;

import ru.hw_5.Entity.Product;
import ru.hw_5.Utilites.CartDAO;
import ru.hw_5.Utilites.ConsoleExectutable;

/**
 * Created by admin on 22.11.2016.
 */
public class ShowCart implements ConsoleExectutable {
    private int cartSize;
    private String result = "";
    private float amount;

    @Override
    public String execut() {
        for (int i = 1; i <= cartSize; i++) {
            Product product = CartDAO.get(i);
            product.setOnCart(true);
            result += product.toString();
            amount += product.getPrice();
        }
        if (result == null) result = "Корзина пуста";
        result+=String.format("Общая сумма покупки: %.1f",amount);
        return result;
    }

    public ShowCart() {
        cartSize = CartDAO.getSize();
    }
}
