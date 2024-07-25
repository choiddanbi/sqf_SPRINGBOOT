package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.service.ComputerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ComputerController {

    @Autowired
    private ComputerServiceImpl computerService;

    // 등록
    @PostMapping("/computer")
    public ResponseEntity<?> registerApi(@RequestBody ReqRegisterComputerDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.registerComputer(reqDto));
    }


    public ResponseEntity<?> modifyApi() {
        return ResponseEntity.ok().body(null);
    }

    // DB에서 가져오기 -> 목록창에 보임
    // GET요청은 param라서 @RequestBody 안해도 됨
    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ReqGetListDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.getComputerList(reqDto));
    }

    public ResponseEntity<?> getApi() {
        return ResponseEntity.ok().body(null);
    }

    public ResponseEntity<?> removeApi() {
        return ResponseEntity.ok().body(null);
    }

}
