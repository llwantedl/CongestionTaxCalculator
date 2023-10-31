package com.example.congestiontaxcalculator.model.tollfee.impl;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.tollfee.TollFeeRange;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DateTimeTollFeeRange implements TollFeeRange {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private BigDecimal tollFee;
    private int priority;
    private City city;

    static final int PRIORITY_OF_FIXED_TOLL = 1;

    public DateTimeTollFeeRange(LocalDateTime startDateTime,
                                LocalDateTime endDateTime,
                                int tollFee,
                                City city) {
        this(startDateTime, endDateTime, BigDecimal.valueOf(tollFee), PRIORITY_OF_FIXED_TOLL, city);
    }

    @Override
    public boolean isInTimeRange(LocalDateTime checkDateTime) {
        return checkDateTime.isAfter(startDateTime) && checkDateTime.isBefore(endDateTime);
    }
}
