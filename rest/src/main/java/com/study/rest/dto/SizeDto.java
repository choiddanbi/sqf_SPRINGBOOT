package com.study.rest.dto;

import com.study.rest.entity.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class SizeDto {

    // 단건조회
    @Builder
    @Data
    public static class Info {
        private int sizeId;
        private String sizeName;
    }

    // 다건조회
    public static List<Info> toList(List<Size> sizeList) {
        return sizeList.stream().map(Size::toDto).collect(Collectors.toList());
    }

    // 다건조회 => 다건조회인 info들을 List 에 담음
    /*@Builder
    @Data
    public static class ListResponse {
        List<Info> sizeList;
    }*/
}
