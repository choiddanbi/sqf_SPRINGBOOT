package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;
import com.study.rest.entity.Size;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;


    @Override
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<Color> getColorListAll() {
        return colorMapper.findAll();
    }

    // register.toEntity() : DTO -> Entity로
    // productMapper.save(register.toEntity()) : xml 실행
    // CommonResponseDto.ofDefault(productMapper.save(register.toEntity())) : 정상 실행 확인
    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register) {
        return CommonResponseDto.ofDefault(productMapper.save(register.toEntity()));

        /*Product product = register.toEntity();
        return productMapper.save(product) > 0;*/
    }

    //11
    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
        /* 아래꺼랑 동일한 코드
        Size size = Size.builder()
                .sizeName(reqRegisterSizeDto.getSizeName())
                .build();

        int successCount = sizeMapper.save(size);
        return CommonResponseDto.ofDefault(successCount);*/

        return CommonResponseDto.ofDefault(sizeMapper.save(reqRegisterSizeDto.toEntity()));
    }

    @Override
    public CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto) {
        return CommonResponseDto.ofDefault(colorMapper.save(reqRegisterColorDto.toEntity()));
    }
}
