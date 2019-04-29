package com.test.provider;

import com.test.dao.WeatherDataRepository;
import com.test.entity.WeatherData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Matt on 29.04.2019 at 19:49.
 */

@Slf4j
@Component
public class ScheduledStation {

    @Autowired
    OwmWeatherProvider owmWeatherProvider;
    @Autowired
    WeatherDataRepository weatherDataRepository;

        @Scheduled(fixedRate = 60000)
        public void checkAndSave() {
            WeatherData weatherData = owmWeatherProvider.getWeatherData();
            log.info("Updating...");
            log.info(weatherData.toString());
            weatherDataRepository.save(weatherData);
        }
}
