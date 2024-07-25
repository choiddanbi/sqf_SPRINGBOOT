package com.study.rest.dto;

import lombok.Data;

//DB에서 데이터 가져오려고
@Data
public class ReqGetListDto {
    private String company;
    private String cpu;
}
