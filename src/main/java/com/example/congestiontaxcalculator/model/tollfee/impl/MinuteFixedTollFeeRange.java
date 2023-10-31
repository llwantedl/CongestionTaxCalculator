package com.example.congestiontaxcalculator.model.tollfee.impl;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.tollfee.TollFeeRange;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class MinuteFixedTollFeeRange implements TollFeeRange {
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal tollFee;
    private int priority;
    private City city;

    static final int PRIORITY_OF_MINUTE_FIXED_TOLL = 3;

    public MinuteFixedTollFeeRange(int startHour,
                                   int startMinute,
                                   int endHour,
                                   int endMinute,
                                   BigDecimal tollFee,
                                   City city) {
        this(LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute), tollFee, PRIORITY_OF_MINUTE_FIXED_TOLL, city);
    }

    public MinuteFixedTollFeeRange(int startHour,
                                   int startMinute,
                                   int endHour,
                                   int endMinute,
                                   int tollFee,
                                   City city) {
        this(startHour, startMinute, endHour, endMinute, BigDecimal.valueOf(tollFee), city);
    }

    @Override
    public boolean isInTimeRange(LocalDateTime checkDateTime) {
        LocalTime checkTime = checkDateTime.toLocalTime();

        return checkTime.getMinute() > startTime.getMinute() &&
                checkTime.getMinute() < endTime.getMinute() &&
                checkTime.getHour() > startTime.getHour() &&
                checkTime.getHour() < endTime.getHour();
    }
}
