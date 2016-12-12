package ru.hw_5.Utilites;

import java.util.Scanner;

/**
 * Created by admin on 21.11.2016.
 */
public class Reader {
    private static Scanner instance;

    public static String getUserInput(){
        if (instance==null){
            instance = new Scanner(System.in);
        }
        String input;
        input = instance.nextLine();
        return input;
    }

    private Reader() {
    }
}
