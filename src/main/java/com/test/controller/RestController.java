package com.test.controller;

import com.test.dao.WeatherDataRepository;
import com.test.entity.WeatherData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Matt on 24.04.2019 at 19:01.
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private WeatherDataRepository weatherDataRepository;

    public RestController(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    @GetMapping("/")
    public String test() {
        return "Is working!";
    }


    @PostMapping("/save")
    public String save() {
        weatherDataRepository.save(new WeatherData(9, 9, 9, 9, 9));
        return "Saved!";
    }


}
