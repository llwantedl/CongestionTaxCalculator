package com.example.congestiontaxcalculator.model.congestiontax.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CongestionTaxStrategyFactory {

    private Map<CongestionTaxStrategyType, CongestionTaxStrategy> congestionTaxStrategies;

    @Autowired
    public CongestionTaxStrategyFactory(Set<CongestionTaxStrategy> strategySet) {
        congestionTaxStrategies = new HashMap<>();
        strategySet.forEach(strategy -> congestionTaxStrategies.put(strategy.getType(), strategy));
    }

    public CongestionTaxStrategy getCongestionTaxStrategy(CongestionTaxStrategyType congestionTaxStrategyType) {
        return congestionTaxStrategies.get(congestionTaxStrategyType);
    }
}
