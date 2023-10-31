package com.example.congestiontaxcalculator.model.congestiontax.service;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CheckInDto;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CongestionTaxDto;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CongestionTaxResult;
import com.example.congestiontaxcalculator.model.congestiontax.strategy.CongestionTaxStrategy;
import com.example.congestiontaxcalculator.model.congestiontax.strategy.CongestionTaxStrategyFactory;
import com.example.congestiontaxcalculator.model.congestiontax.strategy.CongestionTaxStrategyParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CongestionTaxServiceImpl implements CongestionTaxService {
    private final CongestionTaxStrategyFactory congestionTaxStrategyFactory;

    @Override
    public CongestionTaxResult calculate(List<CheckInDto> checkIns) {

        if (checkIns.isEmpty()) {
            throw new RuntimeException("Empty check ins");
        }
        List<CongestionTaxDto> result = new ArrayList<>();

        Map<City, List<CheckInDto>> checkInsAggregatedByCity = checkIns.stream()
                .collect(Collectors.groupingBy(CheckInDto::city));

        //AGGREGATE BY CITY
        checkInsAggregatedByCity.keySet().forEach(city -> {
            List<CheckInDto> checkInsInCity = checkInsAggregatedByCity.get(city);
            checkInsInCity.sort(CheckInDto::compareTo);

            CongestionTaxStrategy congestionTaxStrategy = congestionTaxStrategyFactory
                    .getCongestionTaxStrategy(city.getCongestionTaxStrategyType());

            CongestionTaxDto congestionTaxDto = congestionTaxStrategy
                    .calculate(new CongestionTaxStrategyParams(checkInsInCity, city));

            result.add(congestionTaxDto);
        });

        return new CongestionTaxResult(result);
    }

}
