package com.senlainc.domas.testprojectweather.job;

import com.senlainc.domas.testprojectweather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoJob {

    @Value(value = "${param.city}")
    private String city;

    private WeatherService weatherService;

    @Scheduled(fixedRate = 100000L)
    public void saveDataAboutWeather(){
        weatherService.saveWeatherInfo(city);
    }

    @Autowired
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
