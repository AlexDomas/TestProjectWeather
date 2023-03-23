package com.senlainc.domas.testprojectweather.service.impl;

import com.senlainc.domas.testprojectweather.client.WeatherClient;
import com.senlainc.domas.testprojectweather.dto.AverageWeatherDataDto;
import com.senlainc.domas.testprojectweather.dto.WeatherInfoResponseDto;
import com.senlainc.domas.testprojectweather.entity.CurrentWeather;
import com.senlainc.domas.testprojectweather.exception.CityNotFoundException;
import com.senlainc.domas.testprojectweather.exception.NoWeatherDataBetweenDatesException;
import com.senlainc.domas.testprojectweather.mapper.WeatherMapper;
import com.senlainc.domas.testprojectweather.repository.CurrentWeatherRepository;
import com.senlainc.domas.testprojectweather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import com.senlainc.domas.testprojectweather.constant.MessageExceptionConstant;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {
    private WeatherClient weatherClient;
    private WeatherMapper weatherMapper;
    private CurrentWeatherRepository currentWeatherRepository;

    @Override
    public void saveWeatherInfo(String city) {
        ResponseEntity<WeatherInfoResponseDto> response = weatherClient.getWeatherInfo(city);

        if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            throw new CityNotFoundException(MessageExceptionConstant.CITY_NOT_FOUND_EXCEPTION_MESSAGE + city);
        }

        if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
            WeatherInfoResponseDto weatherInfoResponseDto = response.getBody();
            CurrentWeather currentWeather = weatherMapper.mapToCurrentWeather(weatherInfoResponseDto);
            currentWeatherRepository.save(currentWeather);
        }

    }

    @Override
    public CurrentWeather getLastWeather() {
        return currentWeatherRepository
                .findLastWeather()
                .orElseThrow(() -> new NoWeatherDataBetweenDatesException(MessageExceptionConstant.LAST_WEATHER_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public void getAverageParametersBetweenDates(AverageWeatherDataDto averageWeatherDataDto, LocalDate from, LocalDate to) {
        List<CurrentWeather> listOfWeathers = currentWeatherRepository.findAllByDateBetween(from, to);

        if (listOfWeathers.size() == 0) {
            throw new NoWeatherDataBetweenDatesException(MessageExceptionConstant.NO_WEATHER_DATA_BETWEEN_DATES_EXCEPTION_MESSAGE
                    + "(" + from + ", " + to + ")");
        }

        double averageTemp = 0.0;
        double averageWindSpeed = 0.0;
        double averageAtmospherePressure = 0.0;
        double averageAirHumidity = 0.0;

        int sizeOfList = listOfWeathers.size();

        for (CurrentWeather currentWeather : listOfWeathers) {
            averageTemp += currentWeather.getTemperature();
            averageAtmospherePressure += currentWeather.getAtmospherePressure();
            averageWindSpeed += currentWeather.getWindSpeed();
            averageAirHumidity += currentWeather.getAirHumidity();
        }

        averageWeatherDataDto.setAverageTemperature(averageTemp / sizeOfList);
        averageWeatherDataDto.setWindSpeed(averageWindSpeed / sizeOfList);
        averageWeatherDataDto.setAtmospherePressure(averageAtmospherePressure / sizeOfList);
        averageWeatherDataDto.setAirHumidity(averageAirHumidity / sizeOfList);
    }

    @Autowired
    public void setWeatherClient(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Autowired
    public void setWeatherMapper(WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
    }

    @Autowired
    public void setCurrentWeatherRepository(CurrentWeatherRepository currentWeatherRepository) {
        this.currentWeatherRepository = currentWeatherRepository;
    }

}
