package com.colony.controller;

import com.colony.meteo.provider.OwmWeatherProvider;
import com.colony.persistence.dao.WeatherDataRepository;
import com.colony.persistence.entity.WeatherData;
import com.colony.persistence.service.BeehiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
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
    @Autowired
    BeehiveService beehiveService;

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        LocalDateTime dateTime = LocalDateTime.now();
        long year = 130000000 + dateTime.getYear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy HH:mm:ss");
        model.addAttribute("Date", dateTime.format(formatter));
        model.addAttribute("BeeDate", year);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("logout", true);
        return "login";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/meteo")
    public String meteo(Model model) {
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        WeatherData weatherData = owmWeatherProvider.getWeatherData();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy HH:mm:ss");
        model.addAttribute("Date", zonedDateTimeNow.format(formatter));
        model.addAttribute("Meteo", weatherData.toString());
        return "meteo";
    }



    @GetMapping("/403")
    public String accesDenied() {
        return "403";
    }


}
