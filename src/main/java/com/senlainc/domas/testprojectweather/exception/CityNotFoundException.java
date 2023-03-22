package com.senlainc.domas.testprojectweather.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String msg){
        super(msg);
    }

}
