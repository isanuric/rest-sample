package com.isanuric.websample.user;

/*
 * ----------------------------------------------
 * (c) 2018 Copyright iC Consult GmbH
 * <p/>
 * Project: web-sample
 * @author ehsan.salmani@ic-consult.de on 23/12/2018.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String description;

    private User() {
    }

    public User(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }
}
