package com.funtl.spring.cloud.alibaba.consumer;


import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.funtl.spring.cloud.alibaba.consumer.configure.MessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding({MessageSource.class})
//@EnableBinding({MessageSource.class, AdminLoginLogSink.class})
public class ConsumerApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

}
