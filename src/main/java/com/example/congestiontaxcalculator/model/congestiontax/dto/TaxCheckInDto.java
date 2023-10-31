package com.example.congestiontaxcalculator.model.congestiontax.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaxCheckInDto {
    LocalDateTime checkInTime;
    BigDecimal tollFee;
}
