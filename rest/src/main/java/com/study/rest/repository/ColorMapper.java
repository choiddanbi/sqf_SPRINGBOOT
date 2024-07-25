package com.study.rest.repository;

import com.study.rest.entity.Color;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColorMapper {
    int save(Color color);
    List<Color> findAll(); // 다건조회
    // Color findAll(); 단건조회
}
