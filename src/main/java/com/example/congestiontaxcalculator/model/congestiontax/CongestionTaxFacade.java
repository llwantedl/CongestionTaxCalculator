package com.example.congestiontaxcalculator.model.congestiontax;

import com.example.congestiontaxcalculator.model.congestiontax.dto.CalculateCongestionTaxRequest;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CalculateCongestionTaxResponse;

public interface CongestionTaxFacade {
    CalculateCongestionTaxResponse calculate(CalculateCongestionTaxRequest calculateCongestionTaxRequest);
}
