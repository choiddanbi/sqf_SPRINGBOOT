package com.study.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.TypedValue;

// 라이브러리에 있는 클래스를 IoC container 에 등록하는 방법
@Configuration
public class TestConfig {

    @Bean
    public TypedValue typedValue() {
        return new TypedValue(null);
    }
}
