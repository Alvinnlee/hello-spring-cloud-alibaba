package com.funtl.spring.cloud.alibaba.consumer.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.funtl.spring.cloud.alibaba.consumer.service.bService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class B {


    @Autowired
    private bService bService;


    @RequestMapping("b1")
    public  String a(  ){
        String a = bService.insert( "1");
        return a;
    }

    @RequestMapping("b2")
//    @SentinelResource("message")
    public  String a1( String id , String name){

        return bService.insert( "1");
    }
}
