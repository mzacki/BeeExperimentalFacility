package com.colony.persistence.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Matt on 13.06.2019 at 17:28.
 */

@Data
@Entity
@Table(name="queen")
public class Queen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="year")
    private int year;
    @Column(name="marking")
    private String marking;
    @Column(name="breed")
    private String breed;

    public Queen() {}

    public Queen(int year, String marking, String breed) {
        this.year = year;
        this.marking = marking;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Queen{" +
                "id=" + id +
                ", year=" + year +
                ", marking='" + marking + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

}
