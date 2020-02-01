package com.funtl.spring.cloud.alibaba.consumer.configure;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {

    @Output("admin-login-log-topic")
    MessageChannel adminLoginLog();

    @Output("output2")
    MessageChannel output2();

}
