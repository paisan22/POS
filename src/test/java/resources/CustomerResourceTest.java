package resources;

import database.Database;
import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by paisanrietbroek on 01/10/16.
 */
public class CustomerResourceTest {

    private CustomerResource customerResource;

    /*
        Testen met nep database
     */
    @Before
    public void setCustomerResource() {
        this.customerResource = new CustomerResource();
    }

    @Test
    public void getAllCustomers() throws Exception {

        int databaseSize = this.customerResource.getAllCustomers().size();
        int numberOfCustomers = 5;

        assertThat(databaseSize, is(numberOfCustomers));
    }

    @Test
    public void addCustomer() throws Exception {
        this.customerResource.addCustomer(new Customer("Willy", "Orange"));

        int result = Database.getDatabase().getCustomers().size();
        int mustBe = 5;

        assertThat(result, is(mustBe));
    }

    @Test
    public void getCustomer() throws Exception {
        Customer customer = Database.getDatabase().getCustomers().get(0);
        Customer customer1 = this.customerResource.getCustomer(1);

        boolean result = customer.equals(customer1);

        assertEquals(result, true);
    }

    @Test
    public void setCustomer() throws Exception {
        this.customerResource.setCustomer(1, "Hollebolle", "Gijs");
        Customer customer = this.customerResource.getCustomer(1);
        boolean result = (customer.getFirstname() == "Hollebolle");

        assertThat(result, is(true));
    }
}