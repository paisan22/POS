package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by paisanrietbroek on 03/10/16.
 *
 * De oracle database.
 */
public class DB {

    private static Connection connection = null;

    private static DB instance = null;

    protected DB() {
    }

    public static DB getDatabase() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }
    public Connection getConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.connection;
    }
}
