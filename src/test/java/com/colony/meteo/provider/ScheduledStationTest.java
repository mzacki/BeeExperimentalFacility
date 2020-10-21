package com.colony.meteo.provider;

import com.colony.persistence.dao.WeatherDataRepository;
import com.colony.persistence.entity.WeatherData;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Matt on 29.05.2019 at 19:28.
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledStationTest {

    @Autowired
    OwmWeatherProvider owmWeatherProvider;
    @Autowired
    WeatherDataRepository weatherDataRepository;

    @BeforeClass
    public static void testFirst() {
        log.info("Running test 'before class'");
    }

    @Before
    public void testBefore() {
        log.info("Running test 'before'");
    }

    @Test
    public void checkAndSave() {
        WeatherData weatherData = owmWeatherProvider.getWeatherData();
        Assert.assertNotNull(weatherData);
    }

    @After
    public void testAfter() {
        log.info("Running test 'after'");
    }

    @AfterClass
    public static void testLast() {
        log.info("Running test 'after class'");
    }
}