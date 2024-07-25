package com.study.rest.dto;

import lombok.Builder;
import lombok.Data;

// entity -> dto로 ??
@Builder
@Data
public class RespGetListDto {
    private int computerId;
    private String company;
}
