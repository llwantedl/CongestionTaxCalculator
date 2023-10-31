package com.example.congestiontaxcalculator.model.congestiontax.service;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.Vehicle;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CheckInDto;
import com.example.congestiontaxcalculator.model.congestiontax.dto.CongestionTaxResult;

import java.time.LocalDateTime;
import java.util.List;

public interface CongestionTaxService {
    CongestionTaxResult calculate(List<CheckInDto> checkIns);
}
