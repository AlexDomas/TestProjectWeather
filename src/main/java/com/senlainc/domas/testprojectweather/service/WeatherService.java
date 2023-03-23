package com.senlainc.domas.testprojectweather.service;

import com.senlainc.domas.testprojectweather.dto.AverageWeatherDataDto;
import com.senlainc.domas.testprojectweather.entity.CurrentWeather;

import java.time.LocalDate;

public interface WeatherService {

    void saveWeatherInfo(String city);

    CurrentWeather getLastWeather();

    void getAverageParametersBetweenDates(AverageWeatherDataDto averageWeatherDataDto, LocalDate from, LocalDate to);

}
