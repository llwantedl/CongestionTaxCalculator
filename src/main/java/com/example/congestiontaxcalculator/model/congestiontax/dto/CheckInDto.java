package com.example.congestiontaxcalculator.model.congestiontax.dto;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.Vehicle;

import java.time.LocalDateTime;

public record CheckInDto(LocalDateTime checkInDate,
                         Vehicle vehicle,
                         City city) implements Comparable<CheckInDto>{

    @Override
    public int compareTo(CheckInDto o) {
        return checkInDate.compareTo(o.checkInDate);
    }
}
