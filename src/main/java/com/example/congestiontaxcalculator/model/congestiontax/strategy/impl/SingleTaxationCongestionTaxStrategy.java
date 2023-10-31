package com.example.congestiontaxcalculator.model.congestiontax.strategy.impl;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.Vehicle;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CheckInDto;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CongestionTaxDto;
import com.example.congestiontaxcalculator.model.congestiontax.dto.TaxCheckInDto;
import com.example.congestiontaxcalculator.model.congestiontax.strategy.CongestionTaxStrategy;
import com.example.congestiontaxcalculator.model.congestiontax.strategy.CongestionTaxStrategyParams;
import com.example.congestiontaxcalculator.model.congestiontax.strategy.CongestionTaxStrategyType;
import com.example.congestiontaxcalculator.model.tollfee.TollFeeRangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SingleTaxationCongestionTaxStrategy implements CongestionTaxStrategy {

    public static final BigDecimal MAXIMAL_FEE = BigDecimal.valueOf(60);

    private final TollFeeRangeService tollFeeRangeService;

    @Override
    public CongestionTaxStrategyType getType() {
        return CongestionTaxStrategyType.SINGLE_TAXATION;
    }

    @Override
    public CongestionTaxDto calculate(CongestionTaxStrategyParams congestionTaxStrategyParams) {
        List<TaxCheckInDto> checkInSingleTaxesInfo = new ArrayList<>();

        City city = congestionTaxStrategyParams.city();

        if (congestionTaxStrategyParams.checkIns().isEmpty()) {
            return new CongestionTaxDto(List.of(), BigDecimal.ZERO, city);
        }

        //First element preparation out of cycle
        CheckInDto firstCheckIn = congestionTaxStrategyParams.checkIns().remove(0);
        LocalDateTime tempCheckIn = firstCheckIn.checkInDate();
        BigDecimal firstFee = getTollFee(tempCheckIn, firstCheckIn.vehicle(), city);
        checkInSingleTaxesInfo.add(new TaxCheckInDto(tempCheckIn, firstFee));

        //First element will always be a starting totalFee
        BigDecimal totalFee = firstFee;

        for (CheckInDto checkIn : congestionTaxStrategyParams.checkIns()) {
            Vehicle vehicle = checkIn.vehicle();

            BigDecimal tempFee = getTollFee(tempCheckIn, vehicle, city);
            BigDecimal nextFee = getTollFee(checkIn.checkInDate(), vehicle, city);

            if (Math.abs(ChronoUnit.HOURS.between(checkIn.checkInDate(), tempCheckIn)) < 1) {
                if (totalFee.compareTo(BigDecimal.ZERO) > 0)
                    totalFee = totalFee.subtract(tempFee);
                if (nextFee.compareTo(tempFee) >= 0) {
                    tempCheckIn = checkIn.checkInDate();
                    tempFee = nextFee;
                }
                totalFee = totalFee.add(tempFee);
            } else {
                totalFee = totalFee.add(nextFee);
            }

            checkInSingleTaxesInfo.add(new TaxCheckInDto(checkIn.checkInDate(), nextFee));
        }

        if (totalFee.compareTo(MAXIMAL_FEE) > 0) totalFee = MAXIMAL_FEE;

        return new CongestionTaxDto(checkInSingleTaxesInfo, totalFee, city);
    }

    public BigDecimal getTollFee(LocalDateTime date, Vehicle vehicle, City city) {
        if (vehicle.isTallFree()) return BigDecimal.ZERO;

        return tollFeeRangeService.getTollFee(date, city);
    }
}
