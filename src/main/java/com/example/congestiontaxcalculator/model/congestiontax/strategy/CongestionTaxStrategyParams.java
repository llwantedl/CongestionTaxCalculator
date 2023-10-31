package com.example.congestiontaxcalculator.model.congestiontax.strategy;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CheckInDto;

import java.util.List;

public record CongestionTaxStrategyParams(List<CheckInDto> checkIns,
                                          City city) {
}
