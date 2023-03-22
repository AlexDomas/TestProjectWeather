package com.senlainc.domas.testprojectweather.client.impl;

import com.senlainc.domas.testprojectweather.client.WeatherClient;
import com.senlainc.domas.testprojectweather.dto.WeatherInfoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Component
public class RapidWeatherClientImpl implements WeatherClient {

    @Value("${rapid.get.weather-info.url}")
    private String weatherUrl;

    @Value("${api.key.rapidapi}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<WeatherInfoResponseDto> getWeatherInfo(String city) {
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);

        HttpEntity<String> request = new HttpEntity<>(headers);
        URI url = new UriTemplate(weatherUrl).expand(city);

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                WeatherInfoResponseDto.class
        );
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
