package ru.hw_5.Utilites.Commands;

import ru.hw_5.Main;
import ru.hw_5.Utilites.CartDAO;
import ru.hw_5.Utilites.ConsoleExectutable;

/**
 * Created by admin on 22.11.2016.
 */
public class Exit implements ConsoleExectutable {
    @Override
    public String execut() {
        CartDAO.saveCart();
        Main.setIsStop(true);
        return "Всего доброго";
    }
}
