package com.example.congestiontaxcalculator.model.tollfee.impl;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.tollfee.TollFeeRange;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;

@Getter
@AllArgsConstructor
public class MonthTollFeeRange implements TollFeeRange {

    private Month month;
    private BigDecimal tollFee;
    private int priority;
    private City city;

    static final int PRIORITY_OF_FIXED_TOLL = 1;

    public MonthTollFeeRange(Month month,
                             int tollFee,
                             City city) {
        this(month, BigDecimal.valueOf(tollFee), PRIORITY_OF_FIXED_TOLL, city);
    }

    @Override
    public boolean isInTimeRange(LocalDateTime checkDateTime) {
        return checkDateTime.get(ChronoField.MONTH_OF_YEAR) == month.getValue();
    }
}
