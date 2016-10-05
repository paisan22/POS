package database;

import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paisanrietbroek on 03/10/16.
 */
public class ProductDAO {

    public ProductDAO () {}

    public List<Product> getAllProducts() throws SQLException {

        List<Product> products = new ArrayList<Product>();

        try {

            String sql = "SELECT * FROM product";
            PreparedStatement preparedStatement = DB.getDatabase().getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                products.add(product);
            }

            preparedStatement.close();
            resultSet.close();
            DB.getDatabase().getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product addProduct(Product product) throws SQLException {
        Connection conn = DB.getDatabase().getConnection();

        String sql = "INSERT INTO product VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setDouble(3, product.getPrice());

        preparedStatement.execute();

        preparedStatement.close();
        conn.close();

        return product;
    }

    public boolean deleteProduct(int id) throws SQLException {
        Connection conn = DB.getDatabase().getConnection();

        String sql = "DELETE FROM product WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, id);

        boolean execute = preparedStatement.execute();

        preparedStatement.close();
        conn.close();

        return execute;
    }

    public boolean updateProduct(int id, String name, double price) throws SQLException {
        Connection conn = DB.getDatabase().getConnection();

        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, price);
        preparedStatement.setInt(3, id);

        boolean execute = preparedStatement.execute();

        preparedStatement.close();
        conn.close();

        return execute;

    }
}
