package com.study.rest.controller;

import com.study.rest.dto.ReqTeacherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BasicTeacherController {

    @CrossOrigin
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> basicPost(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("teacher : {}", reqTeacherDto);
        return ResponseEntity.ok().body(reqTeacherDto); // 크롬 콘솔에 찍힘
    }
}
