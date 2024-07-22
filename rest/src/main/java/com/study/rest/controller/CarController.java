package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) { // 크롬 url 에서 들어오는 값 localhost:8080/car?model="쏘나타"
        return carService.getCar(model);
    }

}

/*
* 요청 GET - /car?model=K5 또는 car?model=소나타
*
* CarEntity         -> model, color
*
* CarRepository     -> Car findCarByModel(String model) // 메소드
*     -> List<Car>
*           -> index0: Car(model: "쏘나타", color: "화이트")
*           -> index1: Car(model: "K5", color: "블랙")
*
* CarService        -> Car getCar(String model)
*
* CarController     -> Car getCar(@RequestParam String model)
*
* 의존관계 : CarController -의존-> CarService -의존-> CarRepository
* */
