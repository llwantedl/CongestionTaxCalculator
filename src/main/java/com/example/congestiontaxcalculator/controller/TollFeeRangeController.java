package com.example.congestiontaxcalculator.controller;

import com.example.congestiontaxcalculator.model.congestiontax.dto.CalculateCongestionTaxResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Demonstration controller to show the future idea of how toll fee ranges are added by toll fee range administrator*/
@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/v1/toll-fee")
public class TollFeeRangeController {

    //@PostMapping("/calculate")
    public ResponseEntity<CalculateCongestionTaxResponse> addTollFeeRange() {
        return ResponseEntity.ok().build();
    }

}
