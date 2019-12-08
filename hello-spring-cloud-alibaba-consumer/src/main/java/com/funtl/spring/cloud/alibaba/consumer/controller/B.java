package com.funtl.spring.cloud.alibaba.consumer.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("t")
public class B {




    @RequestMapping("b")
    public  String a(){
        return "ok";
    }
}
