package com.bwap.weatherapp.WeatherApp.scheduler;

import com.bwap.weatherapp.WeatherApp.service.TimeWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DemoServiceBasicUsageCron {
@Autowired
TimeWeatherService timeWeatherService;
    @Scheduled(cron = "0 * * * * ?")
    public void demoServiceMethod() {
        timeWeatherService.add("tehran");
        timeWeatherService.add("hamedan");
        timeWeatherService.add("tabriz");
        timeWeatherService.add("lorestan");
    }
}
