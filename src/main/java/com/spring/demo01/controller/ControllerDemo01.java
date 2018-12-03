package com.spring.demo01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo01 {

    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }

}
