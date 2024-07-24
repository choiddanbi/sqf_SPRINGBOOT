package com.study.rest.entity;

import com.study.rest.dto.SizeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Size {
    private int sizeId;
    private String sizeName;

    public SizeDto.Info toDto() {
        return SizeDto.Info.builder()
                .sizeId(sizeId)
                .sizeName(sizeName)
                .build();
    }
}
