package com.example.congestiontaxcalculator.model.congestiontax.dto;

import com.example.congestiontaxcalculator.model.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CongestionTaxDto {
    private List<TaxCheckInDto> checkInsTaxHistory;
    private BigDecimal congestionTax;
    private City city;
}
