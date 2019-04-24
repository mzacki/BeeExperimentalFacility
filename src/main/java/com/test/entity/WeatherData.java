package com.test.entity;

import javax.persistence.*;

/**
 * Created by Matt on 20.09.2018 at 20:20.
 */

@Entity
@Table(name="conditions")
public class WeatherData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
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

    public WeatherData() {}

    /*public WeatherData(int id, double temperature, double wind, double pressure, double cloudCover,
                       double humidity) {
        this.id = id;
        this.temperature = temperature;
        this.wind = wind;
        this.pressure = pressure;
        this.cloudCover = cloudCover;
        this.humidity = humidity;
    }*/

    public WeatherData(double temperature, double wind, double pressure, double cloudCover,
                       double humidity) {
        this.temperature = temperature;
        this.wind = wind;
        this.pressure = pressure;
        this.cloudCover = cloudCover;
        this.humidity = humidity;
    }


    @Override
    public String toString() {
        return "Current meteo conditions in " +
                "temperature: " + temperature + " \'C" + '\n' +
                "wind speed: " + wind + " m/s" + '\n' +
                "pressure: " + pressure + " hpa" + '\n' +
                "humidity: " + humidity + " %" + '\n' +
                "cloudCover: " + cloudCover + " %" + '\n';
    }
}
