package services;

import database.ProductDAO;
import models.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by paisanrietbroek on 03/10/16.
 */
public class ProductService {

    public List<Product> getAllProducts() throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getAllProducts();
    }

    public Product addProduct(Product product) throws SQLException {
        Product product1 = new ProductDAO().addProduct(product);
        return product1;
    }

    public boolean deleteProduct(int id) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.deleteProduct(id);
    }

    public boolean updateProduct(int id, String newName, double newPrice) throws SQLException {
        return new ProductDAO().updateProduct(id, newName, newPrice);
    }
}
