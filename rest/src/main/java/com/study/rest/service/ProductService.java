package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;
import java.util.List;

//10 service = controller = dto
public interface ProductService {
    List<SizeDto.Info> getSizeListAll();
    List<Color> getColorListAll();
    CommonResponseDto registerProduct(ProductDto.Register register);
    CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto);
    CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto);
}
