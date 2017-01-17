package ru.hw_5.Utilites.Commands;

import ru.hw_5.Entity.Product;
import ru.hw_5.Utilites.CartDAO;
import ru.hw_5.Utilites.ConsoleExectutable;
import ru.hw_5.Utilites.ProductDAO;

/**
 * Created by admin on 04.12.2016.
 */
public class DeleteFromCart implements ConsoleExectutable {
    private Product product;
    @Override
    public String execut() {
        if (product==null) return "Товар не найден";
        CartDAO.delete(product);
        product.setQuantityOnCart(product.getQuantityOnCart()-1);
        product.setQuantityOnShop(product.getQuantityOnShop()+1);
        return String.format("Товар - %s удален из корзины",product.getName());
    }

    public DeleteFromCart(String args) {
        try{
            int id = Integer.parseInt(args);
            this.product = CartDAO.getById(id);
        } catch (Exception e){
            this.product = CartDAO.getByName(args);
        }
    }
}
