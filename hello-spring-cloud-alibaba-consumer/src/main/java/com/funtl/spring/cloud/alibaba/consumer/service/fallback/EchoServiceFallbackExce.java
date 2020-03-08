package com.funtl.spring.cloud.alibaba.consumer.service.fallback;

import com.funtl.spring.cloud.alibaba.consumer.service.EchoService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class EchoServiceFallbackExce implements FallbackFactory<EchoService> {
    @Override
    public EchoService create(Throwable throwable) {
        return  new EchoService(){

            @Override
            public String echo(String string) {
                log.error( "1{}" ,throwable );
                System.out.println(throwable);
                return "fail";
            }
        };
    }
}
