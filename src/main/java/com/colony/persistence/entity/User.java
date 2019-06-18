package com.colony.persistence.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * Created by Matt on 17.05.2019 at 09:31.
 */

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "authority")
    private String authority;

    @Column(name = "enabled")
    private int enabled;

}
