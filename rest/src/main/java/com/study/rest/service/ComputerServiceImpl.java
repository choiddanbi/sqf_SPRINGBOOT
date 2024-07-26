package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // 위에꺼랑 동일!
    public List<RespGetListDto> getComputerList2(ReqGetListDto reqDto) {
        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .build();

        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer); // db에서 찾아서 computers에 담기

        return computers.stream().map(com -> RespGetListDto.builder()
                .computerId(com.getComputerId())
                .company(com.getCompany())
                .build()
                ).collect(Collectors.toList());
            }

    public RespGetComputerDto getComputer(int computerId) {
        // db에서 computer객체 entity 로 가져옴
        Computer computer = computerMapper.findComputerById(computerId);

        // dto로 변환 (react한테 보내야하니까)
        return  RespGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }

    public int deleteComputer(int computerId) {
        return computerMapper.delete(computerId);
    }

    public int updateComputer(ReqUpdateComputerDto reqDto) {
        // dto 로 변환 (react한테 보내기)
        Computer computer = Computer.builder()
                .computerId(reqDto.getComputerId())
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();
        
        return  computerMapper.update(computer);
    }

}
