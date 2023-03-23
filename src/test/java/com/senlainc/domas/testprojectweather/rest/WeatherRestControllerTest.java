package com.senlainc.domas.testprojectweather.rest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
@ActiveProfiles("test")
public class WeatherRestControllerTest {

    @SuppressWarnings(value = "all")
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWeather_CheckingForGettingLastWeather_ShouldReturnStatusOK() throws Exception {
        this.mockMvc.perform(get("/api/v1/weather/last-weather"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getDateBetween_CheckingForGettingAverageValuesBetweenDates_ShouldReturnNotFoundStatus() throws Exception {
        this.mockMvc.perform(get("/api/v1/weather/between-date").param("from", "23-02-2023").param("to", "23-02-2023"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getDateBetween_CheckingForGettingAverageValuesBetweenDates_ShouldReturnStatusOK() throws Exception {
        this.mockMvc.perform(get("/api/v1/weather/between-date").param("from", "23-03-2023").param("to", "23-03-2023"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
