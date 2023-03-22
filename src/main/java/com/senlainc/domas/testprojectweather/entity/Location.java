package com.senlainc.domas.testprojectweather.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
public class Location extends BaseEntity {

    @Column(name = "city")
    private String city;

    public Location(String city) {
        this.city = city;
    }
}
