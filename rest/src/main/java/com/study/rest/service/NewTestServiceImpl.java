package com.study.rest.service;

import org.springframework.stereotype.Service;

@Service
public class NewTestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("새로운 단위 테스트 실행");
    }
}
