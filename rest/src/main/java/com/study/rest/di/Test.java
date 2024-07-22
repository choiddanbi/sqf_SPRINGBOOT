package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Test {
    // DI 하기 전
    class A2 {
        private B2 b2;

        public void testA2() {
            b2 = new B2(); // B2가 있어야 A2를 실행 가능하기 때문에 A2가 B2를 의존!!
            System.out.println("A객체에서 호출");
            b2.testB2();
        }
    }

    class B2 {
        public void testB2() {
            System.out.println("B객체에서 호출");
        }
    }


    public class Test2 {
        private A2 a2;

        public Object iocController() {
            a2.testA2();
            return null;
        }
    }


    // DI 한 후
    class A {
        B b;
        public A(B b) {
            this.b = b;
        }

        public void testA() {
            System.out.println("A객체에서 호출");
            b.testB();
        }
    }

    class B {
        public void testB() {
            System.out.println("B객체에서 호출");
        }
    }


    public class Test3 {
        B b = new B();
        A a = new A(b);

        public Object iocController() {
            a.testA();
            return null;
        }
    }


    // IoC 후
    @Service
    class A3 {
        @Autowired
        B3 b3;

        /*public A3(B3 b3) {
            this.b3 = b3;
        }*/

        public void testA3() {
            System.out.println("A객체에서 호출");
            b3.testB3();
        }
    }

    @Service
    class B3 {
        public void testB3() {
            System.out.println("B객체에서 호출");
        }
    }


    @ResponseBody
    @Controller
    public class Test4 {
        @Autowired
        A3 a3;

        @GetMapping("/test4")
        public Object iocController() {
            a3.testA3();
            return null;
        }
    }
}
