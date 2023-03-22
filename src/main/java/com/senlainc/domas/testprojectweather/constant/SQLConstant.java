package com.senlainc.domas.testprojectweather.constant;

public interface SQLConstant {

    String SELECT_LAST_WEATHER_SQL = "SELECT * FROM weather ORDER BY created DESC LIMIT 1 ";

    String SELECT_WEATHER_BETWEEN_DATES_SQL = "SELECT * FROM weather ORDER BY created DESC LIMIT 1 ";

}
