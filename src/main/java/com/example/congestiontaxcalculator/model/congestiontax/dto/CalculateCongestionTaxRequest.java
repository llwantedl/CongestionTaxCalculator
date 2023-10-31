package com.example.congestiontaxcalculator.model.congestiontax.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CalculateCongestionTaxRequest {
    private final List<CheckInDto> checkIns = new ArrayList<>();
}
