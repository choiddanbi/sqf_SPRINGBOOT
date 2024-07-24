package com.study.rest.repository;

import com.study.rest.entity.Product;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductMapper {
    int save(Product product);
}
