package com.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Matt on 23.04.2019 at 19:31.
 */

@Entity
public class Insert {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String message;

    public Insert() {}

    public Insert(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
