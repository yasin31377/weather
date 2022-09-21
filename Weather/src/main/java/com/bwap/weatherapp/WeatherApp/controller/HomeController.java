package com.bwap.weatherapp.WeatherApp.controller;

import com.bwap.weatherapp.WeatherApp.model.TimeWeather;
import com.bwap.weatherapp.WeatherApp.service.TimeWeatherService;
import elemental.json.JsonObject;
import elemental.json.impl.JreJsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HomeController {
@Autowired
TimeWeatherService timeWeatherService;

@RequestMapping(value = "",method = RequestMethod.GET)
public String home(){

    List<TimeWeather> findAll =  timeWeatherService.findAllByCityName("tehran");
    for (TimeWeather timeWeather:findAll) {

    }
    return findAll.toString() ;
}
}
