package com.example.congestiontaxcalculator.model.tollfee.impl;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.tollfee.TollFeeRange;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

@Getter
@AllArgsConstructor
public class DayOfWeekTollFeeRange implements TollFeeRange {

    private DayOfWeek dayOfWeek;
    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;
    private BigDecimal tollFee;
    private int priority;
    private City city;

    static final int PRIORITY_OF_FIXED_TOLL = 1;

    public DayOfWeekTollFeeRange(DayOfWeek dayOfWeek,
                                 LocalDateTime startPeriod,
                                 LocalDateTime endPeriod,
                                 int tollFee,
                                 City city) {
        this(dayOfWeek, startPeriod, endPeriod, BigDecimal.valueOf(tollFee), PRIORITY_OF_FIXED_TOLL, city);
    }

    @Override
    public boolean isInTimeRange(LocalDateTime checkDateTime) {
        return checkDateTime.get(ChronoField.DAY_OF_WEEK) == dayOfWeek.getValue();
    }
}
