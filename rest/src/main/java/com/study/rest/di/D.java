package com.study.rest.di;

import org.springframework.stereotype.Component;

//@Component
@Component // ioc container 에 D 객체 등록
public class D {

    public void dCall() {
        System.out.println("D 객체에서 메소드 호출");
    }
}
