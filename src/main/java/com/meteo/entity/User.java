package com.meteo.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * Created by Matt on 17.05.2019 at 09:31.
 */

@Data
@Entity
@Table(name = "***REMOVED***s")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "***REMOVED***name")
    private String ***REMOVED***name;

    @Column(name = "***REMOVED***word")
    private String ***REMOVED***word;

    @Column(name = "role")
    private String role;

    @Column(name = "authority")
    private String authority;

    @Column(name = "enabled")
    private int enabled;

}
