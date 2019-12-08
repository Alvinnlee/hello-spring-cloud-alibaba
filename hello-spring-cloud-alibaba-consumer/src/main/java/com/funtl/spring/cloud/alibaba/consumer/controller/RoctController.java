package com.funtl.spring.cloud.alibaba.consumer.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RestController
public class RoctController {



    @Resource
    private MessageProducer producer;

//    @PostConstruct
    @RequestMapping("d")
    public String a(){
        boolean b = producer.sendAdminLoginLog("我爱你");
        System.out.println( b );

        return "好的";
    }

}
