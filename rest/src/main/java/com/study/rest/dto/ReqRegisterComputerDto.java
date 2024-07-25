package com.study.rest.dto;

import lombok.Data;


// react에서의 컴퓨터 객체들 응답 받으려고
@Data
public class ReqRegisterComputerDto {
    private String company;
    private String cpu;
    private int ram;
    private int ssd;
}
