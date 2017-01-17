package ru.hw_5.Utilites.Commands;

import ru.hw_5.Entity.Product;
import ru.hw_5.Utilites.ConsoleExectutable;
import ru.hw_5.Utilites.ProductDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by admin on 04.12.2016.
 */
public class ShowProductImg implements ConsoleExectutable {
    private Product product;
    private String TmpImgPath ="src\\ru\\hw_5\\Tmp\\tmp_img.jpg";
    private String FullImgPath;
    @Override
    public String execut() {
        if (product==null) return "Товар не найден";
        try {
            FileInputStream is = new FileInputStream(product.getImgPath());
            FileOutputStream os = new FileOutputStream(TmpImgPath);
            while (is.available()>0){
                os.write(is.read());
            }
            is.close();
            os.close();
            File file = new File(TmpImgPath);
            FullImgPath=file.getAbsolutePath();
            DisplayImage(FullImgPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FullImgPath;
    }

    public ShowProductImg(String args) {
        try{
            int id = Integer.parseInt(args);
            this.product = ProductDAO.getById(id);
        } catch (Exception e){
            this.product = ProductDAO.getByName(args);
        }
    }
    public void DisplayImage(String filePath) throws IOException
    {
        BufferedImage img= ImageIO.read(new File(filePath));
        ImageIcon icon=new ImageIcon(img);
        int height = icon.getIconHeight();
        int width = icon.getIconWidth();
        System.out.println(width);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(width,height);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
    }
}
