import database.Database;
import models.Product;
import models.Sale;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by paisanrietbroek on 30/09/16.
 */
public class SaleTest {

    /**
     * Deze testen zijn nog met de neppe database.
     *
     * 1: Brood
     * 2: Boter
     * 3: Kaas
     * 4: Ham
     * 5: Melk
     */

    private Sale sale;

    @Before
    public void createSale() {
        this.sale = new Sale(new ArrayList<Product>());
    }

    @Test
    public void addKaasProduct() throws Exception {
        this.sale.addProduct(3);
        assertThat(sale.getProducts().get(0).getName(), is(Database.getDatabase().getProducts().get(2).getName()));
    }

    @Test
    public void getTotalPrice() throws Exception {
        this.sale.addProduct(1);
        this.sale.addProduct(3);
        this.sale.addProduct(5);

        assertThat(this.sale.getTotalPrice(), is(7.45));
    }

    @Test
    public void payOff() throws Exception {

        // sum = 7.45
        this.sale.addProduct(1);
        this.sale.addProduct(3);
        this.sale.addProduct(5);

        double amount = 10.0;

        double change = this.sale.payOff(amount);

        double result = 2.55;

        assertThat(change, is(result));
    }

    @Test
    public void getChange() throws Exception {
        // sum = 7.45
        this.sale.addProduct(1);
        this.sale.addProduct(3);
        this.sale.addProduct(5);

        double amount = 20.0;

        double result = this.sale.getChange(amount);
        double change = amount - this.sale.getTotalPrice();

        assertThat(result, is(change));
    }
}