package resources;

import models.Sale;
import services.SaleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by paisanrietbroek on 03/10/16.
 */

@Path("/sales")
public class SaleResource {

    private SaleService saleService = new SaleService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sale> getAllSales() {
        return this.saleService.getAllSales();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sale addSale(Sale sale) {
        return this.saleService.addSale(sale);
    }
}
