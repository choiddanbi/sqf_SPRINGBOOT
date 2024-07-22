package com.study.rest.service;

import org.springframework.stereotype.Service;

@Service("ts")
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("기존 단위 테스트 실행");
    }
}
