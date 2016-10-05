package services;

import database.Database;
import models.Sale;

import java.util.List;

/**
 * Created by paisanrietbroek on 03/10/16.
 */
public class SaleService {

    public List<Sale> getAllSales() {
        return Database.getDatabase().getSales();
    }

    public Sale addSale(Sale sale) {
        Database.getDatabase().addSale(sale);
        return sale;
    }
}
