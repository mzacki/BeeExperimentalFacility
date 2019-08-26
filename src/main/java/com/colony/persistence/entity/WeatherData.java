package com.colony.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Matt on 20.09.2018 at 20:20.
 */

@Data
@Entity
@Table(name="conditions")
public class WeatherData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="date")
    private LocalDate date;
    @Column(name="time")
    private LocalTime time;
    @Column(name="temperature")
    private double temperature;
    @Column(name="wind")
    private double wind;
    @Column(name="pressure")
    private double pressure;
    @Column(name="cloud_cover")
    private double cloudCover;
    @Column(name="humidity")
    private double humidity;

    private WeatherData() {}

    public WeatherData(double temperature, double wind, double pressure, double cloudCover,
                       double humidity) {
        this.temperature = temperature;
        this.wind = wind;
        this.pressure = pressure;
        this.cloudCover = cloudCover;
        this.humidity = humidity;
    }

    public WeatherData(LocalDate date, LocalTime time, double temperature, double wind, double pressure, double cloudCover, double humidity) {
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.wind = wind;
        this.pressure = pressure;
        this.cloudCover = cloudCover;
        this.humidity = humidity;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return "Significant for: " + date + " " + time.format(formatter) + '\n' +
                "temperature: " + temperature + " \'C" + '\n' +
                "wind speed: " + wind + " m/s" + '\n' +
                "pressure: " + pressure + " hpa" + '\n' +
                "humidity: " + humidity + " %" + '\n' +
                "cloudCover: " + cloudCover + " %" + '\n';
    }
}
