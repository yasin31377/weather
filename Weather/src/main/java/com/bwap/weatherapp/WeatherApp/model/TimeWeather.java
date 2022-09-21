package com.bwap.weatherapp.WeatherApp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor //(access = AccessLevel.PROTECTED,force = true)
public class TimeWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   // private Date placedAt=new Date();
    @Getter
    @Setter
    private String cityName;
    @Getter
    @Setter
    private String weather;
    @Getter
    @Setter
    private String time;

    public TimeWeather(String cityName, String weather, String time) {
        this.cityName = cityName;
        this.weather = weather;
        this.time = time;
    }
    public String toString() {
        return "{" +
                "cityName=" + cityName +
                "'\n," +
                " weather='\t"  + weather +
                "'\n," +
                " time='" + time +
                "'\n" +
                "}"
               ;
    }
}
