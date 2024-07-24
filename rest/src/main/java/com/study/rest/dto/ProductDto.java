package com.study.rest.dto;

import com.study.rest.entity.Product;
import lombok.Data;

public class ProductDto {

    @Data
    public static class Register { // 내부클래스로 Dto 묶기
        private String productName;
        private int price;
        private int sizeId;
        private int colorId;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .price(price)
                    .sizeId(sizeId)
                    .colorId(colorId)
                    .build();
        }
    }
}
