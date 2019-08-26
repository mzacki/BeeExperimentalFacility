package com.colony.meteo.provider;

import com.colony.persistence.entity.WeatherData;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Matt on 11.09.2018 at 20:41.
 */
@Component
public class OwmWeatherProvider {

    private OWM owm;

    public OwmWeatherProvider() {
        this.owm = new OWM("dcf890fc0ba06ef58dd0ec3a8842e983");
    }

    public WeatherData getWeatherData() {


        CurrentWeather cwd = null;


        try {
            cwd = owm.currentWeatherByCoords(50.081926, 18.675203);
            //cwd = owm.currentWeatherByCityName(location.getName());
        } catch (APIException e) {
            e.printStackTrace();
        }

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        // String localisation = cwd.getCityName();
        if (cwd != null) {
            double windSpeed = cwd.getWindData().getSpeed();
            double temperature = Math.round(cwd.getMainData().getTemp() - 273.15);
            double pressure = cwd.getMainData().getPressure();
            double humidity = cwd.getMainData().getHumidity();
            double cloudCover = cwd.getCloudData().getCloud();
            // List<Weather> overall = cwd.getWeatherList();
            // String description = String.valueOf(cwd.getWeatherList().get(0).getMoreInfo());

            return new WeatherData(zonedDateTimeNow.toLocalDate(), zonedDateTimeNow.toLocalTime(), temperature, windSpeed,
                    pressure,
                    humidity,
                    cloudCover);
        } else {
            return null;
        }






    }

}
