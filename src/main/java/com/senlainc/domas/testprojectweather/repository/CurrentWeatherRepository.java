package com.senlainc.domas.testprojectweather.repository;

import com.senlainc.domas.testprojectweather.entity.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather, UUID> {

    @Query(value = "SELECT * FROM weather ORDER BY created DESC LIMIT 1 ", nativeQuery = true)
    Optional<CurrentWeather> findLastWeather();

    @Query(value = "SELECT * FROM   weather WHERE date BETWEEN :from AND :to", nativeQuery = true)
    List<CurrentWeather> findAllByDateBetween(@Param(value = "from") LocalDate from, @Param(value = "to") LocalDate to);

}
