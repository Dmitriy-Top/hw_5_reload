package ru.hw_5.Utilites.Commands;

import ru.hw_5.Utilites.ConsoleExectutable;
import ru.hw_5.Utilites.ProductDAO;

/**
 * Created by admin on 21.11.2016.
 */
public class ShowProducts implements ConsoleExectutable {
    @Override
    public String execut() {
        String result = "";
        int size = ProductDAO.getSize();
        for (int i = 1; i<=size; i++){
            result += ProductDAO.get(i).toString();
        }
        if (result == null) result = "Нет товаров";
        return result;
    }
}
