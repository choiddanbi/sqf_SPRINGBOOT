package com.study.rest.di;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class A {

    private B b;

    public void aCall() {
        System.out.println("A 객체에서 메소드 호출");
        b.bCall();
    }
}
