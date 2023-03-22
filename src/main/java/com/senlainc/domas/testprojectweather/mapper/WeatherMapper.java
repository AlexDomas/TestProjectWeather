package com.senlainc.domas.testprojectweather.mapper;

import com.senlainc.domas.testprojectweather.dto.WeatherInfoResponseDto;
import com.senlainc.domas.testprojectweather.dto.WeatherResponseDto;
import com.senlainc.domas.testprojectweather.entity.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WeatherMapper {
    private final LocationMapper locationMapper;

    @Autowired
    public WeatherMapper(LocationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    public CurrentWeather mapToCurrentWeather(WeatherInfoResponseDto weatherInfoResponseDto) {
        WeatherResponseDto weatherResponseDto = weatherInfoResponseDto.getWeatherResponseDto();

        return new CurrentWeather(weatherResponseDto.getTemperature(),
                weatherResponseDto.getWindSpeed(),
                weatherResponseDto.getAtmospherePressure(),
                weatherResponseDto.getAirHumidity(),
                weatherResponseDto.getWeatherCondition().getConditionText(),
                locationMapper.mapToLocation(weatherInfoResponseDto.getLocationResponseDto()),
                LocalDate.parse(weatherResponseDto.getDate().split(" ")[0])
        );
    }

}
