package services;

import database.Database;
import models.Customer;

import java.util.List;

/**
 * Created by paisanrietbroek on 01/10/16.
 */
public class CustomerService {

    public List<Customer> getAllCustomers() {

        return Database.getDatabase().getCustomers();
    }

    public Customer addCustomer(Customer customer) {
        Database.getDatabase().addCustomer(customer.getFirstname(), customer.getLastname());
        int index = Database.getDatabase().getCustomers().size() - 1;

        return Database.getDatabase().getCustomers().get(index);
    }

    public Customer getCustomer(int id) {
        Customer customer = null;
        for (Customer c : Database.getDatabase().getCustomers()) {
            if (id == c.getId()) {
                customer = c;
            }
        }
        return customer;
    }

    public void setCustomer(int i, String firstname, String lastname) {
        for (Customer c : Database.getDatabase().getCustomers()) {
            if (c.getId() == i) {
                c.setFirstname(firstname);
                c.setLastname(lastname);
            }
        }
    }
}
