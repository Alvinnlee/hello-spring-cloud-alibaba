package com.funtl.spring.cloud.alibaba.consumer;

import com.funtl.spring.cloud.alibaba.consumer.configure.AdminLoginLogSink;
import com.funtl.spring.cloud.alibaba.consumer.configure.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding({MessageSource.class, AdminLoginLogSink.class})
public class ConsumerApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
