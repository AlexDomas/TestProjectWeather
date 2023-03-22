package com.senlainc.domas.testprojectweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AverageWeatherDataDto {

    @JsonProperty(value = "average_temp")
    private double averageTemperature;

    @JsonProperty(value = "average_wind_speed")
    private double windSpeed;

    @JsonProperty(value = "average_atm_pressure")
    private double atmospherePressure;

    @JsonProperty(value = "average_air_humidity")
    private double airHumidity;

}
