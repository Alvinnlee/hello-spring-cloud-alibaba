package com.funtl.spring.cloud.alibaba.consumer.service.impl;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class bServiceImplHandler {

    public static  String blockHandler(String name , BlockException e){
        System.out.println( "触发blockex1");
        return "触发blockex1";
    }
}
