package ru.hw_5.Utilites.Commands;

import ru.hw_5.Entity.Product;
import ru.hw_5.Utilites.CartDAO;
import ru.hw_5.Utilites.ConsoleExectutable;
import ru.hw_5.Utilites.ProductDAO;

/**
 * Created by admin on 22.11.2016.
 */
public class AddToCart implements ConsoleExectutable {
    private Product product;

    public AddToCart(String args) {
        try{
            int id = Integer.parseInt(args);
            this.product = ProductDAO.getById(id);
        } catch (Exception e){
            this.product = ProductDAO.getByName(args);
        }
    }

    @Override
    public String execut() {
        if (product==null) return "Товар не найден";
        if (product.getQuantityOnShop()==0) return "Товар отсутствует на складе";
        CartDAO.create(product);
        product.setQuantityOnCart(product.getQuantityOnCart()+1);
        product.setQuantityOnShop(product.getQuantityOnShop()-1);
        return String.format("Товар - %s добавлен в корзину",product.getName());
    }
}
