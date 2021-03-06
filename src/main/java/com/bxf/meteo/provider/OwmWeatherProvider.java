package com.bxf.meteo.provider;

import com.bxf.persistence.entity.WeatherData;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Matt on 11.09.2018 at 20:41.
 */
@Component
public class OwmWeatherProvider {

    private final OWM owm;

    @Autowired
    public OwmWeatherProvider() {
        this.owm = new OWM("");
    }

    public WeatherData getWeatherData() {

        CurrentWeather cwd = null;

        try {
            cwd = owm.currentWeatherByCoords(50, 19);
        } catch (APIException e) {
            e.printStackTrace();
        }

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("Europe/Paris"));

        if (cwd != null) {
            double windSpeed = cwd.getWindData().getSpeed();
            double temperature = Math.round(cwd.getMainData().getTemp() - 273.15);
            double pressure = cwd.getMainData().getPressure();
            double humidity = cwd.getMainData().getHumidity();
            double cloudCover = cwd.getCloudData().getCloud();

            return new WeatherData(zonedDateTimeNow.toLocalDate(), zonedDateTimeNow.toLocalTime(), temperature, windSpeed,
                    pressure,
                    humidity,
                    cloudCover);
        } else {
            return null;
        }

    }

}
