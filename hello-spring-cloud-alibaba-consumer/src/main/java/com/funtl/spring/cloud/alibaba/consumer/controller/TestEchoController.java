package com.funtl.spring.cloud.alibaba.consumer.controller;

import com.funtl.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEchoController {

    @Autowired
    private EchoService echoService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/feign/echo/{str}" )
    public String echo(@PathVariable String str) {
        System.out.println( port );
        return echoService.echo(str);
    }
}
