package com.senlainc.domas.testprojectweather.exception;

public class NoWeatherDataBetweenDatesException extends RuntimeException{

    public NoWeatherDataBetweenDatesException(String msg){
        super(msg);
    }

}
