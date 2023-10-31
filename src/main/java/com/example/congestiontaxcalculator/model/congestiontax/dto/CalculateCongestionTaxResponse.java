package com.example.congestiontaxcalculator.model.congestiontax.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalculateCongestionTaxResponse {
    private CongestionTaxResult congestionTaxResult;
}
