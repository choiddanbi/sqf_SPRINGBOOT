package com.study.rest.controller;

import com.study.rest.dto.ReqStudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Rest API : view 리턴이 아닌 data 리턴!!
@Slf4j
@RestController // 이거 쓰면 @ResponseBody 안적어도 됨
public class BasicController {

    @CrossOrigin
    @PostMapping("/basic/student")
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) { //json으로 요청 들어오면 무조건 @RequestBody, ResponseEntity = 응답데이터의 타입
        log.info("Student : {}", reqStudentDto);
        return ResponseEntity.ok().body(null); // ok -> 상태코드가 200, badRequest() -> 상태코드가 400
    }
}
