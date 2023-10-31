package com.example.congestiontaxcalculator.model.tollfee;

import com.example.congestiontaxcalculator.model.City;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TollFeeRange {
     City getCity();
     BigDecimal getTollFee();
     int getPriority();
     boolean isInTimeRange(LocalDateTime checkDateTime);
}
