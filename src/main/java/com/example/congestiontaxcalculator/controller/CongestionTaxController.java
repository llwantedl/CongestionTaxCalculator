package com.example.congestiontaxcalculator.controller;

import com.example.congestiontaxcalculator.model.congestiontax.CongestionTaxFacade;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CalculateCongestionTaxRequest;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CalculateCongestionTaxResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/congestion-tax")
public class CongestionTaxController {

    private final CongestionTaxFacade congestionTaxFacade;

    @PostMapping("/calculate")
    public ResponseEntity<CalculateCongestionTaxResponse> calculateTax(
            @RequestBody CalculateCongestionTaxRequest calculateCongestionTaxRequest) {
        return ResponseEntity.ok(congestionTaxFacade.calculate(calculateCongestionTaxRequest));
    }

}
