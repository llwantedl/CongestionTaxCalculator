package com.example.congestiontaxcalculator.model.tollfee;

import com.example.congestiontaxcalculator.model.City;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TollFeeRangeService {
    BigDecimal getTollFee(LocalDateTime date, City city);
}
