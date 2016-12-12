package ru.hw_5.Utilites;

import ru.hw_5.Utilites.Commands.*;

/**
 * Created by admin on 21.11.2016.
 */
public class CommandFactory{

    public static ConsoleExectutable getCommand(String input) {
        String[] command = input.split("\\s+");
        String args ="";
        for (int i = 1; i< command.length;i++){
            args += command[i];
            if (i!=command.length-1) args+=" ";
        }

        switch (command[0]) {
            case "showProducts":
                return new ShowProducts();
            case "showProductImg":
                return new ShowProductImg(args);
            case "addToCart":
                return new AddToCart(args);
            case "showCart":
                return new ShowCart();
            case "deletefromCart":
                return new DeleteFromCart(args);
            case "help":
                return new Help();
            case "exit":
                return new Exit();
            default:
                return new Help();
        }
    }
}
