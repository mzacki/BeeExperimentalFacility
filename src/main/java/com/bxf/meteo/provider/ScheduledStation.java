package com.bxf.meteo.provider;

import com.bxf.persistence.dao.WeatherDataRepository;
import com.bxf.persistence.entity.WeatherData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Matt on 29.04.2019 at 19:49.
 */

@Slf4j
@Component
public class ScheduledStation {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduledStation.class);

    private final OwmWeatherProvider owmWeatherProvider;
    private final WeatherDataRepository weatherDataRepository;

    @Autowired
    public ScheduledStation(OwmWeatherProvider owmWeatherProvider,
            WeatherDataRepository weatherDataRepository) {
        this.owmWeatherProvider = owmWeatherProvider;
        this.weatherDataRepository = weatherDataRepository;
    }


    @Scheduled(cron = "0 0 1,4,7,10,13,16,19,22 * * *")
        public void checkAndSave() {
            WeatherData weatherData = owmWeatherProvider.getWeatherData();
            LOG.info("Updating...");
            LOG.info(weatherData.toString());
            weatherDataRepository.save(weatherData);
        }

}
