package com.senlainc.domas.testprojectweather.rest;

import com.senlainc.domas.testprojectweather.dto.AverageWeatherDataDto;
import com.senlainc.domas.testprojectweather.entity.CurrentWeather;
import com.senlainc.domas.testprojectweather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Api(description = "Endpoint which helps us to get information about weather")
@RestController
@RequestMapping(value = "/api/v1/weather")
public class WeatherRestController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @ApiOperation(value = "Api for getting last weather from DB")
    @ApiResponse(code = 200, response = CurrentWeather.class, message = "OK")
    @GetMapping(value = "/last-weather")
    public ResponseEntity<CurrentWeather> getWeather() {
        return new ResponseEntity<>(weatherService.getLastWeather(), HttpStatus.OK);
    }

    @ApiOperation(value = "Api for getting average parameters of weather from DB in certain period")
    @ApiResponse(code = 200, response = AverageWeatherDataDto.class, message = "OK")
    @GetMapping(value = "/between-date")
    public ResponseEntity<AverageWeatherDataDto> getDateBetween(@ApiParam(name = "from", value = "27-03-2023")
                                                                @RequestParam(value = "from") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate from,
                                                                @ApiParam(name = "to", value = "27-03-2023")
                                                                @RequestParam(value = "to") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate to) {
        AverageWeatherDataDto averageWeatherDataDto = new AverageWeatherDataDto();
        weatherService.getAverageParametersBetweenDates(averageWeatherDataDto, from, to);
        return new ResponseEntity<>(averageWeatherDataDto, HttpStatus.OK);
    }

}
