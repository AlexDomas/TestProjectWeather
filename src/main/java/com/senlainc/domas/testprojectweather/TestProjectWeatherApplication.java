package com.senlainc.domas.testprojectweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestProjectWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestProjectWeatherApplication.class, args);
    }

}
