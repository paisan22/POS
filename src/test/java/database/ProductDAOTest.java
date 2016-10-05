package database;

import models.Product;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by paisanrietbroek on 05/10/16.
 */
public class ProductDAOTest {

    @Test
    public void getAllProducts() throws Exception {

        ProductDAO productDAO = new ProductDAO();
        for (Product p : productDAO.getAllProducts()) {
            System.out.println("id: " + p.getId());
            System.out.println("name: " + p.getName());
            System.out.println("price: " + p.getPrice());
            System.out.println("-----------------------------");
        }

    }

    @Test
    public void addProduct() throws Exception {
        int id = 6;
        String name = "Soep";
        double price = 5.10;

        Product product = new Product(id, name, price);
        ProductDAO productDAO = new ProductDAO();
        try {
            System.out.println("Added: " + productDAO.addProduct(product));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteProduct() throws Exception {
        int productId = 1;

        new ProductDAO().deleteProduct(productId);
    }

    @Test
    public void updateProduct() throws Exception {
        int productId = 3;
        String newName = "Koe";
        double newPrice = 1000.50;

        new ProductDAO().updateProduct(productId, newName, newPrice);
    }
}