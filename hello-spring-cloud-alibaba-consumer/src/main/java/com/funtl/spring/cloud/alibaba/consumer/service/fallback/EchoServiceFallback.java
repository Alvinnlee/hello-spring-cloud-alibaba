package com.funtl.spring.cloud.alibaba.consumer.service.fallback;

import com.funtl.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.stereotype.Component;


@Component
public class EchoServiceFallback implements EchoService {


    @Override
    public String echo(String string) {
        return "请求也被熔断";
    }
}