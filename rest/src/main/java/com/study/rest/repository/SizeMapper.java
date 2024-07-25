package com.study.rest.repository;

import com.study.rest.entity.Size;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//7
@Mapper
public interface SizeMapper {
    int save(Size size);
    List<Size> findAll();
}
