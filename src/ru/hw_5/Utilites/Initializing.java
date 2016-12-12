package ru.hw_5.Utilites;

import ru.hw_5.Entity.Clothes;
import ru.hw_5.Entity.Food;
import ru.hw_5.Entity.Product;
import ru.hw_5.Entity.TV;
import ru.hw_5.Utilites.Commands.CartDAO;

/**
 * Created by admin on 21.11.2016.
 */
public class Initializing {
    public static void initProductDb(){
        ProductDAO.create(new Food("Колбаса",121.21f,1,500,"src\\ru\\hw_5\\Resource\\img\\kolbasa.jpg"));
        ProductDAO.create(new Food("Хлеб",25.5f,1,600,"src\\ru\\hw_5\\Resource\\img\\hleb.jpg"));
        ProductDAO.create(new Food("Масло",111.0f,1,300,"src\\ru\\hw_5\\Resource\\img\\maslo.jpg"));
        ProductDAO.create(new Clothes("Брюки",1500.00f,2,48,"src\\ru\\hw_5\\Resource\\img\\bryuki.jpg"));
        ProductDAO.create(new Clothes("Рубашка",700.21f,2,52,"src\\ru\\hw_5\\Resource\\img\\rubashka.jpg"));
        ProductDAO.create(new Clothes("Галстук",2000.0f,2,3,"src\\ru\\hw_5\\Resource\\img\\galstuk.jpg"));
        ProductDAO.create(new TV("Panasonic",10000.0f,3,49,"src\\ru\\hw_5\\Resource\\img\\panasonic-tv.jpg"));
        ProductDAO.create(new TV("LG",20000.0f,3,21,"src\\ru\\hw_5\\Resource\\img\\lg-tv.jpg"));
        ProductDAO.create(new TV("Samsung",35000.0f,3,35,"src\\ru\\hw_5\\Resource\\img\\samsung-tv.jpg"));
        CartDAO.loadCart();
    }
}
