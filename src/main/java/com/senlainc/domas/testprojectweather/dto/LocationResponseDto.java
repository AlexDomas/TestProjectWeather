package com.senlainc.domas.testprojectweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LocationResponseDto {

    @JsonProperty(value = "name")
    private String cityName;

}
