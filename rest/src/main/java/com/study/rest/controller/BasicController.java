package com.study.rest.controller;

import com.study.rest.dto.ProductDto;
import com.study.rest.dto.ReqProductDto;
import com.study.rest.dto.ReqStudentDto;
import com.study.rest.service.ProductService;
import com.study.rest.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Rest API : view 리턴이 아닌 data 리턴!!
@Slf4j
@RestController // 이거 쓰면 @ResponseBody 안적어도 됨
public class BasicController {

    @Autowired
    private ProductService productService;

    /**
     * REST API
     * 데이터 통신을 위한 HTTP 요청 방식
     * HTTP(프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
     * REST API의 특징
     * 1. 요청에 대한 동작은 무조건 메소드에 따라서 정의한다.
     *  - 데이터 추가(등록)은 POST 요청으로! -> POST요청은 JSON데이터로 요청!
     *  - 데이터 조회는 GET 요청으로! -> GET요청은 QueryString(=parms)으로 요청!
     *       ex) params 표현법 -> 주소?key1=value1&key2=value2
     *  - 데이터 수정은 PUT, PATCH 요청으로! -> JSON 데이터로 요청
     *       <PUT 요청과 PARCH 요청의 차이점>
     *           PUT요청: 공백 또는 NULL인 데이터도 수정함 // 공백이 넘어올 수 있음!(공백이 받아지게 만들어야함)
     *           PATCH요청: 공백 또는 NULL인 데이터는 수정하지 않음 // 공백이 넘어오면 안됨!(기존 데이터로 받아지게 만들어야함)
     *  - 데이터 삭제는 DELETE 요청으로! -> params
     *
     * 2. 주소(URL) 요청메세지(Resource)
     *  - URL은 가능한 동사를 사용하지 않는다.
     *  - 계층 구조로 작성한다.
     *       ex) /집/주방/가스레인지, /식당/주방/가스레인지
     *  - 요청 메소드 마다 작성하는 방법이 다르다.
     *       ex) 상품 등록 /product
     *           상품 단건 조회(GET) /product/1(id또는 key값으로 들어옴)
     *           상품 다건 조회(GET) /products?page=1&count=30 (한페이지별로 30개씩 조회)
     *           상품 전체 조회(GET) /products
     *           상품 수정(PUT) /product/1(id또는 key값으로 들어옴)
     *           상품 삭제(DELETE) /product/1(id또는 key값으로 들어옴)
     *
     * 3. 주소는 가능한 대문자를 사용하지 않는다.
     * */

    @CrossOrigin
    @PostMapping("/basic/student")
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) { //json으로 요청 들어오면 무조건 @RequestBody, ResponseEntity = 응답데이터의 타입
        log.info("Student : {}", reqStudentDto);
        return ResponseEntity.ok().body(null); // ok -> 상태코드가 200, badRequest() -> 상태코드가 400
    }

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
        // log.info("{}", reqProductDto); // Dto를 DB로 보낼거!
        return ResponseEntity.ok().body(productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }
}
