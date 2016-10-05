package database;

import lombok.Getter;
import models.Customer;
import models.Product;
import models.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paisanrietbroek on 30/09/16.
 *
 * Tijdelijke nep database.
 */

@Getter
public class Database {

    private List<Product> products;
    private List<Customer> customers;
    private List<Sale> sales;

    private static Database database = null;
    protected Database() {

        products = new ArrayList<Product>();

        products.add(new Product(1, "Brood", 2.55));
        products.add(new Product(2, "Boter", 1.25));
        products.add(new Product(3, "Kaas", 1.75));
        products.add(new Product(4, "Ham", 1.55));
        products.add(new Product(5, "Melk", 3.15));

        customers = new ArrayList<Customer>();

        this.addCustomer("Kelly", "Zoetendaal");
        this.addCustomer("Paul", "Rietbroek");
        this.addCustomer("Hans", "Klok");
        this.addCustomer("Lionel", "Messi");

        this.sales = new ArrayList<Sale>();

//        Sale sale1 = new Sale(new ArrayList<Product>());
//        sale1.addProduct(1);
//        sale1.addProduct(3);

//        sale1.addProduct(5);
//        this.addSale(sale1);
//
//        Sale sale2 = new Sale(new ArrayList<Product>());
//        sale2.addProduct(2);
//        sale2.addProduct(1);
//        sale2.addProduct(4);
//        this.addSale(sale2);

    }
    public static Database getDatabase() {
        if(database == null) {
            database = new Database();
        }
        return database;
    }

    public void addCustomer(String firstname, String lastname) {
        Customer customer = new Customer(firstname, lastname);

        int id = this.customers.size() + 1;
        customer.setId(id);

        this.customers.add(customer);
    }

    public void addSale(Sale sale) {
        sale.setId(Database.getDatabase().getSales().size() + 1);
        this.sales.add(sale);
    }

    public void addProduct(Product product) {
        product.setId(Database.getDatabase().getProducts().size() + 1);
        this.products.add(product);
    }
}
