package com.study.rest.dto;

import com.study.rest.entity.Color;
import lombok.Data;

@Data
public class ReqRegisterColorDto {
    private String colorName;

    public Color toEntity() {
        return Color.builder()
                .colorName(colorName)
                .build();
    }
}
