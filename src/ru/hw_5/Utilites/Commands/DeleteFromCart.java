package ru.hw_5.Utilites.Commands;

import ru.hw_5.Entity.Product;
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
        ProductDAO.delete(product.getId());
        return String.format("Товар - %s добавлен в корзину",product.getName());
    }

    public DeleteFromCart(String args) {
        try{
            int id = Integer.parseInt(args);
            this.product = ProductDAO.getById(id);
        } catch (Exception e){
            this.product = ProductDAO.getByName(args);
        }
    }
}
