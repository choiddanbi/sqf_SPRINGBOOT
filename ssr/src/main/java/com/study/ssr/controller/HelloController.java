package com.study.ssr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello/1")
    public ModelAndView helloPage1() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/hello");
        return mav;
    }
}
