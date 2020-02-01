package com.funtl.spring.cloud.alibaba.consumer.controller;

import com.funtl.spring.cloud.alibaba.consumer.configure.MessageSource;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

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

    public <T> void sendTransactionalMsg(T msg, int num) throws Exception {
        MessageBuilder builder = MessageBuilder.withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
        builder.setHeader("test", String.valueOf(num));
        builder.setHeader(RocketMQHeaders.TAGS, "binder");
        Message message = builder.build();
        source.output2().send(message);
    }
}
