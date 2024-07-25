package com.study.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Computer { // db랑~
    private int computerId;
    private String company;
    private String cpu;
    private int ram;
    private int ssd;
}
