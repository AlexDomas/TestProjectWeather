package com.senlainc.domas.testprojectweather.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class WeatherResponseDto {

    @JsonProperty(value = "temp_c")
    private int temperature;

    @JsonProperty(value = "wind_mph")
    private int windSpeed;

    @JsonProperty(value = "pressure_mb")
    private int atmospherePressure;

    @JsonProperty(value = "humidity")
    private int airHumidity;

    @JsonProperty(value = "condition")
    private ConditionResponseDto weatherCondition;

    @JsonProperty(value = "last_updated")
    private String date;

}
