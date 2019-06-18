package com.colony.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Matt on 13.06.2019 at 17:21.
 */

@Getter
@Setter
@Table(name="beehives")
@Entity
public class Beehive {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="colour")
    private String colour;

    @Column(name="start_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name="end_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name="numbers")
    private int numbers;

    @Column(name="breed")
    private String breed;

    @Column(name="nuc")
    private boolean nuc;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="queen_id")
    private Queen queen;

    public Beehive() {}

    public Beehive(String colour, String breed) {
        this.colour = colour;
        this.breed = breed;
    }

    public Beehive(String colour, String breed, Queen queen) {
        this.colour = colour;
        this.breed = breed;
        this.queen = queen;
    }
}
