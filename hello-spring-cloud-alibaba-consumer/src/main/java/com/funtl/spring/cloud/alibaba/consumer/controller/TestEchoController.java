package com.funtl.spring.cloud.alibaba.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.funtl.spring.cloud.alibaba.consumer.service.EchoService;
import com.funtl.spring.cloud.alibaba.consumer.until.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestEchoController {

    @Autowired
    private EchoService echoService;

    @Value("${server.port}")
    private String port;

//    @SentinelResource(value = "resource2", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @SentinelResource(value = "resource2", blockHandler = "exceptionHandler")
//    @SentinelResource(value = "get2", fallback  = "handleException", blockHandlerClass = { ExceptionUtil.class })
    @GetMapping(value = "/feign/echo/{str}" )
    public String echo(@PathVariable String str) {
//        System.out.println( port );
//        System.out.println("消费============");
//        System.out.println(echoService.echo(str));
        String a = echoService.echo(str);
        System.out.println(a);


        return a;

//        Map<String,Object> map=new HashMap<>();
//        map.put("method","test2");
//        map.put("msg","自定义限流逻辑处理");
//        return  map;
    }

    // 限流与阻塞处理
    public String exceptionHandler(String id, BlockException e) {
        e.printStackTrace();
        return "错误发生在" + id;
    }



    @PostMapping(value = "/feign" )
    public String echo1( ) {
        System.out.println( port );
        return echoService.echo("1");
    }
}


