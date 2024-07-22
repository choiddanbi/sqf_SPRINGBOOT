package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // ioc container 에 C객체 등록
public class C {

    @Autowired(required = false)
    private D d; // ioc container 에 D 객체가 있는지 확인하고, 있으면 d에 넣어주기

    public void cCall() {
        System.out.println("C 객체에서 메소드 호출");
        d.dCall();
    }
}
