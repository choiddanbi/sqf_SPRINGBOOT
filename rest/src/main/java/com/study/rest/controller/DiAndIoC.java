package com.study.rest.controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // ioc container 에 DiAndIoc 등록
public class DiAndIoC {

    @Autowired // ioc container 에 C 객체가 있는지 확인하고 있으면 c에 넣어주기
    private C c;

    @Autowired
    @Qualifier("ts")
    private TestService testService1;

    @Autowired
    @Qualifier("newTestServiceImpl")
    private TestService testService2;

    @ResponseBody
    @GetMapping("/di")
    public Object di() {
        // A가 B를 의존하는 관계 , 결합도는 낮은 상태
        B b = new B();
        A a = new A(b);
        a.aCall();
        return null;
    }

    @ResponseBody //return 쓰기 위한 용도
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/test") // localhost:8080/test?type=new
    public Object startTest(@RequestParam String type) {
        if("old".equals(type)) { // 크롬 url 에서 localhost:8080/test?type=old
            testService1.test();
        } else {
            testService2.test();
        }
        return null;
    }
}
