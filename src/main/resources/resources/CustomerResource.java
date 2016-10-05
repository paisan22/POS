package resources;

import database.Database;
import models.Customer;
import services.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by paisanrietbroek on 01/10/16.
 */

@Path("/customers")
public class CustomerResource {

    private CustomerService customerService = new CustomerService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer addCustomer(Customer customer) {
        return this.customerService.addCustomer(customer);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int id) {
        return customerService.getCustomer(id);
    }

    @PUT
    @Path("{id}/{firstname}/{lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> setCustomer(@PathParam("id") int id, @PathParam("firstname") String firstname, @PathParam("lastname") String lastname) {
        this.customerService.setCustomer(id, firstname, lastname);

        return Database.getDatabase().getCustomers();
    }
}
