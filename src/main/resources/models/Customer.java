package models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by paisanrietbroek on 01/10/16.
 */

@Getter
@Setter
public class Customer {
    private int id;
    private String firstname;
    private String lastname;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Customer() {
    }
}
