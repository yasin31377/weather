package com.bwap.weatherapp.WeatherApp.repository;

import com.bwap.weatherapp.WeatherApp.model.TimeWeather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<TimeWeather, Integer> {
    List<TimeWeather> findAllByCityName(String cityName);
}
