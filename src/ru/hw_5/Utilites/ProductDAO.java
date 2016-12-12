package ru.hw_5.Utilites;

import ru.hw_5.Entity.Product;

import java.util.ArrayList;

/**
 * Created by admin on 21.11.2016.
 */
public class ProductDAO {
    private static ArrayList<Product> productsList = new ArrayList<>();

    public static Product getById(int id){
        Product result=null;
        for (Product product : productsList){
            if (id ==product.getId()) result=product;
        }
        return result;
    }

    public static Product get(int id){
        Product result= productsList.get(id-1);
        return result;
    }

    public static Product getByName(String name){
        Product result=null;
        for (Product product : productsList){
            if (name.equals(product.getName())) result=product;
        }
        return result;
    }

    public static void create(Product product){
        productsList.add(product);
    }
    public static void update(Product product){
        int id = product.getId();
        int index = -1;
        for (Product prd : productsList){
            if (prd.getId()==id) index = productsList.indexOf(prd);
        }
        productsList.remove(index);
        productsList.add(index,product);
    }
    public static void delete(int id){
        int index = -1;
        for (Product prd : productsList){
            if (prd.getId()==id) index = productsList.indexOf(prd);
        }
        productsList.remove(index);
    }

    public static int getSize(){
        return productsList.size();
    }


    private ProductDAO() {
    }
}
