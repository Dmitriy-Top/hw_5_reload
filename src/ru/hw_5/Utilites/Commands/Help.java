package ru.hw_5.Utilites.Commands;

import ru.hw_5.Utilites.ConsoleExectutable;

/**
 * Created by admin on 21.11.2016.
 */
public class Help implements ConsoleExectutable {

    @Override
    public String execut() {
        return "help - вызов справки \nshowProducts - показать каталог\nshowProductImg %productname or id% - показать изображение товара\naddToCart %productname or id% - добавить товар в карзину \nshowCart - показать продукты в корзине\ndeletefromCart %productname or id% - удолить продукт из корзины\nexit - выход";
    }

    public Help() {
    }
}
