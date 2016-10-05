package models;

import database.Database;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by paisanrietbroek on 30/09/16.
 */

@Getter
@Setter
public class Sale {

    private int id;
    private List<Product> products;

    public Sale(List<Product> products) {
        this.products = products;
    }

    public Sale(){}

    public void addProduct(int i) {
        for (Product p : Database.getDatabase().getProducts()) {
            if (p.getId() == i) {
                this.products.add(p);
                break;
            }
        }
    }
    public Double getTotalPrice() {
        Double result = 0.0;
        for(Product p: this.products) {
             result += p.getPrice();
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        Double formattedResult = Double.parseDouble(decimalFormat.format(result));
        return formattedResult;
    }

    public double payOff(double amount) {
        double change = 0.0;

        if (amount > this.getTotalPrice()) {
            change = getChange(amount);
        }
        return change;
    }

    public double getChange(double amount) {
        double change = amount - this.getTotalPrice();

        return change;
    }
}
