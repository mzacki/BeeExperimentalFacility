package com.meteo.provider;

import com.meteo.dao.WeatherDataRepository;
import com.meteo.entity.WeatherData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Matt on 29.05.2019 at 19:28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledStationTest {

    @Autowired
    OwmWeatherProvider owmWeatherProvider;
    @Autowired
    WeatherDataRepository weatherDataRepository;

    @Test
    public void checkAndSave() {
        WeatherData weatherData = owmWeatherProvider.getWeatherData();
        Assert.assertNotNull(weatherData);
    }
}