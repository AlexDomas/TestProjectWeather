package com.senlainc.domas.testprojectweather.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "weather")
public class CurrentWeather extends BaseEntity implements Serializable {

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "wind_speed")
    private int windSpeed;

    @Column(name = "atmosphere_pressure")
    private int atmospherePressure;

    @Column(name = "air_humidity")
    private int airHumidity;

    @Column(name = "weather_condition")
    private String weatherCondition;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

    public CurrentWeather(int temperature, int windSpeed, int atmospherePressure, int airHumidity, String weatherCondition, Location location, LocalDate date) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.atmospherePressure = atmospherePressure;
        this.airHumidity = airHumidity;
        this.weatherCondition = weatherCondition;
        this.location = location;
        this.date = date;
    }
}
