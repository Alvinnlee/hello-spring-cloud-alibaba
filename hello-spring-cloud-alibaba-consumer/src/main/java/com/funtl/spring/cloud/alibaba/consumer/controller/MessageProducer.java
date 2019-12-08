package com.funtl.spring.cloud.alibaba.consumer.controller;

import com.funtl.spring.cloud.alibaba.consumer.configure.MessageSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageProducer {

    @Resource
    private MessageSource source;
    /**
     * 管理登录日志
     *
     * @param dto {@link dto}
     * @return {@code boolean}
     */
    public boolean sendAdminLoginLog(String dto) {
        return source.adminLoginLog().send(MessageBuilder.withPayload(dto).build());
    }
}
