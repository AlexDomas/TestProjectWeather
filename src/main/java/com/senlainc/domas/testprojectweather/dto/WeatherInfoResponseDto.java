package com.senlainc.domas.testprojectweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WeatherInfoResponseDto {

    @JsonProperty(value = "location")
    private LocationResponseDto locationResponseDto;

    @JsonProperty(value = "current")
    private WeatherResponseDto weatherResponseDto;

}
