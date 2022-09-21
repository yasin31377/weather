package com.bwap.weatherapp.WeatherApp.service;

import com.bwap.weatherapp.WeatherApp.model.TimeWeather;

import java.util.List;

public interface ITimeWeatherService {
    public void add(String cityName);
    public List<TimeWeather> selectAll();
    public List<TimeWeather>findAllByCityName(String cityName);

}
