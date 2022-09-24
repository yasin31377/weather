package com.bwap.weatherapp.WeatherApp.controller;

import com.bwap.weatherapp.WeatherApp.model.TimeWeather;
import com.bwap.weatherapp.WeatherApp.service.TimeWeatherService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import elemental.json.Json;
import elemental.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SpringUI(path = "")
public class ViewHome extends UI {
    @Autowired
    TimeWeatherService timeWeatherService;

    private VerticalLayout mainLayout;
    private Label label;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        mainLayout();
        home("tehran");
    }

    private void mainLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(mainLayout);
    }

    public void home(@RequestBody String cityName){


        List<TimeWeather> findAll = timeWeatherService.findAllByCityName(cityName);
        for (TimeWeather timeWeather : findAll) {
            label = new Label("{\n"+timeWeather.getCityName()+"\n"+timeWeather.getWeather()+"\n"+timeWeather.getTime());
            label.addStyleName(ValoTheme.LABEL_H2);
            label.addStyleName(ValoTheme.LABEL_BOLD);
            mainLayout.addComponent(label);
        }
  }  }

