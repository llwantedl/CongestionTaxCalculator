package com.example.congestiontaxcalculator.model.congestiontax.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CongestionTaxResult {
    private List<CongestionTaxDto> result;
}
