package com.senlainc.domas.testprojectweather.mapper;

import com.senlainc.domas.testprojectweather.dto.LocationResponseDto;
import com.senlainc.domas.testprojectweather.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public Location mapToLocation(LocationResponseDto locationResponseDto) {
        return locationResponseDto != null ? new Location(locationResponseDto.getCityName()) : null;
    }

}
