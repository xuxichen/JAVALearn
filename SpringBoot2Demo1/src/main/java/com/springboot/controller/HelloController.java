package com.springboot.controller;

import com.springboot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@Slf4j
@RestController // 等于上面两个
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return this.car;
    }
    @ResponseBody
    @RequestMapping("/hello")
    public String handle01() {
        log.info("请求进来了");
        return "Hello， Spring Boot 2！！！";
    }
}
