package ru.hw_5.Utilites;

import ru.hw_5.Entity.Clothes;
import ru.hw_5.Entity.Food;
import ru.hw_5.Entity.Product;
import ru.hw_5.Entity.TV;
import ru.hw_5.Utilites.BdHelper;
import ru.hw_5.Utilites.UserMassageHelper;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by admin on 22.11.2016.
 */
public class CartDAO {
    private static ArrayList<Product> cart;
    private static String filePath="src\\ru\\hw_5\\Tmp\\Cart";

    public static Product get(int id){
        Product result = cart.get(id-1);

        return result;
    }
    public static void create(Product product){
        cart.add(product);
    }
    public static void update(Product product){
        int id = product.getId();
        int index = -1;
        for (Product prd : cart){
            if (prd.getId()==id) index = cart.indexOf(prd);
        }
        cart.remove(index);
        cart.add(index,product);
    }
    public static void delete(Product product){
        int id = product.getId();
        int index = -1;
        for (Product prd : cart){
            if (prd.getId()==id) index = cart.indexOf(prd);
        }
        cart.remove(index);
    }

    public static Product getById(int id){
        Product result=null;
        for (Product product : cart){
            if (id ==product.getId()) result=product;
        }
        return result;
    }

    public static Product getByName(String name){
        Product result=null;
        for (Product product : cart){
            if (name.equals(product.getName())) result=product;
        }
        return result;
    }

    public static int getSize(){
        return cart.size();
    }

    public static void saveCart(){
        BdHelper.getInstance().clearTabls();//чистим таблицы
        for (Product product:cart){ //раскладываем по таблицам оъекты
            if (product instanceof Food) BdHelper.getInstance().saveFood((Food)product);
            if (product instanceof Clothes) BdHelper.getInstance().saveClothes((Clothes) product);
            if (product instanceof TV) BdHelper.getInstance().saveTV((TV) product);
        }

    }
    public static void loadCart(){
        ArrayList<Product> array = new ArrayList<>();
        array.addAll(BdHelper.getInstance().loadFood());
        array.addAll(BdHelper.getInstance().loadClothes());
        array.addAll(BdHelper.getInstance().loadTV());
        cart = array;


    }

    private CartDAO() {
    }
}
