package com.senlainc.domas.testprojectweather.repository;

import com.senlainc.domas.testprojectweather.entity.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.senlainc.domas.testprojectweather.constant.SQLConstant;

public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather, UUID> {

    @Query(value = SQLConstant.SELECT_LAST_WEATHER_SQL, nativeQuery = true)
    Optional<CurrentWeather> findLastWeather();

    @Query(value = SQLConstant.SELECT_WEATHER_BETWEEN_DATES_SQL, nativeQuery = true)
    List<CurrentWeather> findAllByDateBetween(@Param(value = "from") LocalDate from, @Param(value = "to") LocalDate to);

}
