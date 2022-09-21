package com.bwap.weatherapp.WeatherApp.service;

import com.bwap.weatherapp.WeatherApp.model.TimeWeather;
import com.bwap.weatherapp.WeatherApp.repository.WeatherRepository;
import elemental.json.JsonObject;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TimeWeatherService implements ITimeWeatherService {
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    WeatherService weatherService;

    String defaultUnit = "\u00b0" + "C";

    @SneakyThrows
    @Override
    public void add(String cityName) {
        TimeWeather timeWeather = new TimeWeather();
        Date date = new Date();
        weatherService.setCityName(cityName);
        JSONObject mainObject = weatherService.returnMain();
        timeWeather.setCityName(cityName);
        timeWeather.setWeather(mainObject.getInt("temp") + defaultUnit);
        timeWeather.setTime((date.toString()));

        weatherRepository.save(timeWeather);

    }

    @Override
    public List<TimeWeather> selectAll() {
        return weatherRepository.findAll();
    }

    @Override
    public List<TimeWeather> findAllByCityName(String cityName) {
      return  weatherRepository.findAllByCityName(cityName);

    }
}
