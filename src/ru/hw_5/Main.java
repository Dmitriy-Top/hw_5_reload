package ru.hw_5;


import ru.hw_5.Utilites.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static boolean isStop;

    public static void main(String[] args) {
        Initializing.initProductDb();
        System.out.println("Добро пожаловать в интернет-магазин");
        while (!isStop){
            String input = Reader.getUserInput();
            ConsoleExectutable command = CommandFactory.getCommand(input);
            String result = command.execut();
            UserMassageHelper.showMassageToUser(result);
        }
    }

    public static void setIsStop(boolean isStop) {
        Main.isStop = isStop;
    }
}
