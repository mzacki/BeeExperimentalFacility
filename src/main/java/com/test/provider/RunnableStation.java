package com.test.provider;

import com.test.dao.WeatherDataRepository;
import com.test.entity.WeatherData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Matt on 10.04.2019 at 17:17.
 */
@Slf4j
@Component
public class RunnableStation implements Runnable {


    private long interval = 10000;
    private boolean on;
    @Autowired
    OwmWeatherProvider owmWeatherProvider;
    @Autowired
    WeatherDataRepository weatherDataRepository;

    @Override
    @Bean
    public void run() {
        on = true;
        while (on) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Thread is working....");

            WeatherData weatherData = owmWeatherProvider.getWeatherData();
            log.info("Updating...");
            log.info(weatherData.toString());
            weatherDataRepository.save(weatherData);
        }
    }

    public void execute() {
        Runnable runnable = new RunnableStation();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void off() {
        on = false;
    }
}
