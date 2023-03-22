package com.senlainc.domas.testprojectweather.client;

import com.senlainc.domas.testprojectweather.dto.WeatherInfoResponseDto;
import org.springframework.http.ResponseEntity;

public interface WeatherClient {

    ResponseEntity<WeatherInfoResponseDto> getWeatherInfo(String city);

}
