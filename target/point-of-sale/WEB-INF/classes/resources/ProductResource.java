package resources;

import models.Product;
import services.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by paisanrietbroek on 03/10/16.
 */

@Path("/products")
public class ProductResource {

    private ProductService productService = new ProductService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() throws SQLException {
        return productService.getAllProducts();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product) throws SQLException {
        return productService.addProduct(product);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteProduct(@PathParam("id") int id) throws SQLException {
        return productService.deleteProduct(id);
    }

    @PUT
    @Path("/{id}/{newname}/{newprice}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateProduct (
            @PathParam("id") int id,
            @PathParam("newname") String newName,
            @PathParam("newprice") double newPrice) throws SQLException {
        return productService.updateProduct(id, newName, newPrice);
    }
}
