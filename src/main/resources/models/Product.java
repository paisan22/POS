package models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by paisanrietbroek on 30/09/16.
 */

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {}
}
