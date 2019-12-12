package com.funtl.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
public class EchoController {


    @Value("${server.port}")
    private String port;


    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("111111111111111111111111111");
        return "Hello Nacos Provider " + port;
    }
}
