package com.example.congestiontaxcalculator.model;

import com.example.congestiontaxcalculator.model.congestiontax.strategy.CongestionTaxStrategyType;
import lombok.AllArgsConstructor;
import lombok.Getter;

//Representation of city. Ideally should be an Entity Object with reference to taxation strategy.
@Getter
@AllArgsConstructor
public enum City {
    GOTHENBURG(CongestionTaxStrategyType.SINGLE_TAXATION),
    KRAKOW(CongestionTaxStrategyType.SINGLE_TAXATION);

    private final CongestionTaxStrategyType congestionTaxStrategyType;
}
