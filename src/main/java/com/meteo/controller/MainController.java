package com.meteo.controller;

import com.meteo.dao.WeatherDataRepository;
import com.meteo.entity.WeatherData;
import com.meteo.provider.OwmWeatherProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Matt on 05.05.2019 at 19:26.
 */
@Controller
public class MainController {

    @Autowired
    OwmWeatherProvider owmWeatherProvider;
    @Autowired
    WeatherDataRepository weatherDataRepository;

    @GetMapping("/index")
    public String index(Model model) {
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        WeatherData weatherData = owmWeatherProvider.getWeatherData();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy HH:mm:ss");
        model.addAttribute("Date", zonedDateTimeNow.format(formatter));
        model.addAttribute("Meteo", weatherData.toString());
        return "index";
    }
}
