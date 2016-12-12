package ru.hw_5.Utilites.Commands;

import ru.hw_5.Entity.Product;
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

    public static int getSize(){
        return cart.size();
    }

    public static void saveCart(){
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cart);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void loadCart(){
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cart = (ArrayList<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            UserMassageHelper.showMassageToUser("Сохраненной корзины не найдено");
            cart = new ArrayList<Product>();
        } catch (IOException e) {
            e.printStackTrace();
            cart = new ArrayList<Product>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cart = new ArrayList<Product>();
        }


    }

    private CartDAO() {
    }
}
