package com.example.congestiontaxcalculator.model.congestiontax.strategy;

import com.example.congestiontaxcalculator.model.congestiontax.dto.CongestionTaxDto;

public interface CongestionTaxStrategy {
    CongestionTaxStrategyType getType();

    CongestionTaxDto calculate(CongestionTaxStrategyParams congestionTaxStrategyParams);
}
