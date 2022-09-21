package com.bwap.weatherapp.WeatherApp.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.io.IOException;

@Service
public class WeatherService {
    private String cityName;
    private String apikey = "93666905d6bcc306a4d91f81debc28e5";
    private String unit="metric";
    private OkHttpClient client;
    private Response response;


    public JSONObject getWeather() {
        client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.openweathermap.org/data/2.5/weather?q=" + getCityName() + "&units=" + unit + "&appid=" + apikey).build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
    public JSONObject returnMain() throws JSONException {
        JSONObject main = getWeather().getJSONObject("main");
        return main;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
