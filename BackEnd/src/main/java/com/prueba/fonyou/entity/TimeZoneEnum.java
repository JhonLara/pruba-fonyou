package com.prueba.fonyou.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TimeZoneEnum {

    COLOMBIA("GMT-5"),
    CHILE("GMT-3"),
    BRASIL("GMT-3");

    private final String value;
}