package com.study.rest.service;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.dto.RespGetListDto;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerServiceImpl {

    @Autowired
    private ComputerMapper computerMapper;

    //CommonResponseDto 사용하지 않고 repository_mapper로 넘겨주는 방법!!
    public int registerComputer(ReqRegisterComputerDto reqDto) {
        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();

        return computerMapper.save(computer);
    }

    //검색
    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
        List<RespGetListDto> respDtos = new ArrayList<>(); // dto -> entity > db에서 쓰려고

        Computer computer = Computer.builder()
                    .company(reqDto.getCompany())
                    .cpu(reqDto.getCpu())
                    .build();
        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer); // db에서 찾아서 computers에 담기

        // entity -> dto로 변환해서 넣기
        for(Computer com : computers) {
            RespGetListDto dto = RespGetListDto.builder()
                        .computerId(com.getComputerId())
                        .company(com.getCompany())
                        .build();

            respDtos.add(dto);
        }

        return respDtos;
    }

}
