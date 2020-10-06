package com.colony.meteo.provider;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Matt on 29.05.2019 at 19:54.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OwmWeatherProviderTest {

    private OWM owm;

    public OwmWeatherProviderTest() {
        this.owm = new OWM("");
    }

    @Test
    public void getWeatherData() {
        CurrentWeather cwd = null;

        try {
            cwd = owm.currentWeatherByCoords();
        } catch (APIException e) {
            e.printStackTrace();
        }

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        // CWD / OWM is external class from dependency. Hence their methods' tests are here.
        Assert.assertNotNull(owm);
        Assert.assertNotNull(cwd);
        Assert.assertNotNull(zonedDateTimeNow);
        Assert.assertNotNull(ZoneId.of("Europe/Paris"));
        Assert.assertNotNull(cwd.getWindData().getSpeed());
        Assert.assertNotNull(Math.round(cwd.getMainData().getTemp() - 273.15));
        Assert.assertNotNull(cwd.getMainData().getPressure());
        Assert.assertNotNull(cwd.getMainData().getHumidity());
        Assert.assertNotNull(cwd.getCloudData().getCloud());
    }
}