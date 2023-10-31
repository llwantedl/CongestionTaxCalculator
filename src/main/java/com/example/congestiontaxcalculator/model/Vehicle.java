package com.example.congestiontaxcalculator.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Ideally to have separate records in database, that will help with adding and managing new types in Runtime
@Getter
@RequiredArgsConstructor
public enum Vehicle {
    CAR(false),
    MOTORCYCLE(true),
    TRACTOR(true),
    //Based on business requirements - below entries could be separated to some separate 'Role' field
    EMERGENCY(true),
    DIPLOMAT(true),
    FOREIGN(true),
    MILITARY(true);

    private final boolean tallFree;
}
