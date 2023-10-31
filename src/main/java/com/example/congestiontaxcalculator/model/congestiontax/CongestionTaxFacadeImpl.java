package com.example.congestiontaxcalculator.model.congestiontax;

import com.example.congestiontaxcalculator.model.congestiontax.dto.CalculateCongestionTaxRequest;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CalculateCongestionTaxResponse;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CongestionTaxResult;
import com.example.congestiontaxcalculator.model.congestiontax.service.CongestionTaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CongestionTaxFacadeImpl implements CongestionTaxFacade {

    private final CongestionTaxService congestionTaxService;

    @Override
    public CalculateCongestionTaxResponse calculate(CalculateCongestionTaxRequest calculateCongestionTaxRequest) {
        CongestionTaxResult tollFee = congestionTaxService.calculate(calculateCongestionTaxRequest.getCheckIns());

        return new CalculateCongestionTaxResponse(tollFee);
    }
}
