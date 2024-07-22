package com.study.rest.di;

import org.springframework.stereotype.Component;

@Component
public class 물리공격방패 implements 방패 {
    @Override
    public void 방어() {
        System.out.println("물리공격을 막습니다.");
    }
}
