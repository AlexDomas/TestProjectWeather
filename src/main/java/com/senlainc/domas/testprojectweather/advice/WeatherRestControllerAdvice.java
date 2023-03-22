package com.senlainc.domas.testprojectweather.advice;

import com.senlainc.domas.testprojectweather.exception.CityNotFoundException;
import com.senlainc.domas.testprojectweather.exception.NoDataWeatherException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class WeatherRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public void handleCityNotFoundException(final CityNotFoundException e) {
        log.error("An exception occurred! ", e);
    }

    @ExceptionHandler(NoDataWeatherException.class)
    public ResponseEntity<String> handleLastWeatherNotFoundException(final NoDataWeatherException e) {
        log.error("An exception occurred! ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
