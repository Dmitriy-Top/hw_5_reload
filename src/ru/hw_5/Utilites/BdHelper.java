package ru.hw_5.Utilites;

import ru.hw_5.Entity.Clothes;
import ru.hw_5.Entity.Food;
import ru.hw_5.Entity.Product;
import ru.hw_5.Entity.TV;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by admin on 17.01.2017.
 */
public class BdHelper {
    private static BdHelper bdHelper;
    private Properties properties;
    private Connection connection;

    private BdHelper() {
        properties = readPropertiesBd();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(properties.getProperty("db.host"), properties.getProperty("db.login"), properties.getProperty("db.password"));
        } catch (ClassNotFoundException e) {
            UserMassageHelper.showMassageToUser("Драйвер JDBC не найден");
        } catch (SQLException e) {
            UserMassageHelper.showMassageToUser("Проблемы с доступом к серверу");
        }


    }

    private Properties readPropertiesBd() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src\\ru\\hw_5\\Resource\\config.properties");
            property.load(fis);

        } catch (IOException e) {
            UserMassageHelper.showMassageToUser("ОШИБКА: Файл настройки отсуствует!");
        }
        return property;
    }

    public static BdHelper getInstance() {
        if (bdHelper == null) bdHelper = new BdHelper();
        return bdHelper;
    }

    public void saveFood(Food product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO food(quantityoncart,oncart,imgpath,objid,categoryid,price,name,weight) values(?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, product.getQuantityOnCart());
            preparedStatement.setBoolean(2, product.isOnCart());
            preparedStatement.setString(3, product.getImgPath());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.setInt(5, product.getCategoryID());
            preparedStatement.setFloat(6, product.getPrice());
            preparedStatement.setString(7, product.getName());
            preparedStatement.setFloat(8, product.getWeight());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveClothes(Clothes product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO clothes(quantityoncart,oncart,imgpath,objid,categoryid,price,name,size) values(?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, product.getQuantityOnCart());
            preparedStatement.setBoolean(2, product.isOnCart());
            preparedStatement.setString(3, product.getImgPath());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.setInt(5, product.getCategoryID());
            preparedStatement.setFloat(6, product.getPrice());
            preparedStatement.setString(7, product.getName());
            preparedStatement.setInt(8, product.getSize());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveTV(TV product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO tv(quantityoncart,oncart,imgpath,objid,categoryid,price,name,diagonal) values(?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, product.getQuantityOnCart());
            preparedStatement.setBoolean(2, product.isOnCart());
            preparedStatement.setString(3, product.getImgPath());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.setInt(5, product.getCategoryID());
            preparedStatement.setFloat(6, product.getPrice());
            preparedStatement.setString(7, product.getName());
            preparedStatement.setFloat(8, product.getDiagonal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void clearTabls() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE food, clothes, tv;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Product> loadFood() {
        Statement statement = null;
        ArrayList<Product> array = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM food");
            while (result.next()) {
                array.add(new Food(result.getString("name"),result.getFloat("price"),result.getInt("categoryid"),result.getFloat("weight"),result.getString("imgpath"),result.getInt("quantityoncart")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }
    public ArrayList<Product> loadTV() {
        Statement statement = null;
        ArrayList<Product> array = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM tv");
            while (result.next()) {
                array.add(new TV(result.getString("name"),result.getFloat("price"),result.getInt("categoryid"),result.getFloat("diagonal"),result.getString("imgpath"),result.getInt("quantityoncart")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public ArrayList<Product> loadClothes() {
        Statement statement = null;
        ArrayList<Product> array = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM clothes");
            while (result.next()) {
                array.add(new Clothes(result.getString("name"),result.getFloat("price"),result.getInt("categoryid"),result.getInt("size"),result.getString("imgpath"),result.getInt("quantityoncart")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }
}
