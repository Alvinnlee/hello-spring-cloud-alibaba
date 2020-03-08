package com.funtl.spring.cloud.alibaba.consumer.service.impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.funtl.spring.cloud.alibaba.consumer.service.bService;
import org.springframework.stereotype.Service;

@Service
public class bServiceImpl implements bService {

    @Override
    @SentinelResource( value = "message",
                        blockHandlerClass = bServiceImplHandler.class,
                        blockHandler = "blockHandler",
                        fallback = "fallback")
    public String insert( String name) {
        return name;
    }

//    public String blockHandler(String name , BlockException e){
//        System.out.println( "触发blockex1");
//        return "触发blockex1";
//    }

    public String fallback(String name , Throwable e){
        System.out.println( "触发Throwable");
        return "触发Throwable";
    }
}
