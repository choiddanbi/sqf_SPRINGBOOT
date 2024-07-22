package com.study.rest.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String model;
    private String color;
}
