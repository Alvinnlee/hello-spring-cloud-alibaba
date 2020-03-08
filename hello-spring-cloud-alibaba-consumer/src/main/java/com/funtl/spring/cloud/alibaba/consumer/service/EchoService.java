package com.funtl.spring.cloud.alibaba.consumer.service;

import com.funtl.spring.cloud.alibaba.consumer.service.fallback.EchoServiceFallback;
import com.funtl.spring.cloud.alibaba.consumer.service.fallback.EchoServiceFallbackExce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider" ,
//            fallback = EchoServiceFallback.class
        fallbackFactory = EchoServiceFallbackExce.class
                )
public interface EchoService {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable("string") String string);
}

