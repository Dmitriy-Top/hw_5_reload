package ru.hw_5.Utilites.Commands;

import ru.hw_5.Utilites.ConsoleExectutable;
import ru.hw_5.Utilites.ProductDAO;

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
            result += CartDAO.get(i).toString();
            amount += CartDAO.get(i).getPrice();
        }
        if (result == null) result = "Корзина пуста";
        result+=String.format("Общая сумма покупки: %s",amount);
        return result;
    }

    public ShowCart() {
        cartSize = CartDAO.getSize();
    }
}
