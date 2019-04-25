package com.test.provider;

import com.test.entity.WeatherData;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.param.Weather;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Matt on 11.09.2018 at 20:41.
 */
@Component
public class OwmWeatherProvider {

    private OWM owm;

    public OwmWeatherProvider() {
        this.owm = new OWM("***REMOVED***");
    }

    public WeatherData getWeatherData() {


        CurrentWeather cwd = null;


        try {
            cwd = owm.currentWeatherByCoords(***REMOVED***, ***REMOVED***);
            //cwd = owm.currentWeatherByCityName(location.getName());
        } catch (APIException e) {
            e.printStackTrace();
        }


        String localisation = cwd.getCityName();
        double windSpeed = cwd.getWindData().getSpeed();
        double temperature = Math.round(cwd.getMainData().getTemp() - 273.15);
        double pressure = cwd.getMainData().getPressure();
        double humidity = cwd.getMainData().getHumidity();
        double cloudCover = cwd.getCloudData().getCloud();
        List<Weather> overall = cwd.getWeatherList();
        String description = String.valueOf(cwd.getWeatherList().get(0).getMoreInfo());


        //return new WeatherData(temperature, windSpeed, pressure, humidity, cloudCover);

        return new WeatherData(LocalDate.now(), LocalTime.now(), temperature, windSpeed, pressure, humidity,
                cloudCover);

    }

}
