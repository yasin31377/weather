package com.bwap.weatherapp.WeatherApp.controller;

import com.bwap.weatherapp.WeatherApp.model.TimeWeather;
import com.bwap.weatherapp.WeatherApp.service.TimeWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HomeController {
@Autowired
TimeWeatherService timeWeatherService;

@RequestMapping(value = "/api/weather",method = RequestMethod.GET)
public List<TimeWeather> home(){
    return  timeWeatherService.findAllByCityName("tehran");
}
}
