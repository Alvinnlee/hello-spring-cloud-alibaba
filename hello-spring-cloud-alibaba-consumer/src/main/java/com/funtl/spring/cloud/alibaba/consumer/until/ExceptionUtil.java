package com.funtl.spring.cloud.alibaba.consumer.until;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public final class ExceptionUtil {

    public static String handleException(BlockException ex) {
        System.err.println("错误发生: " + ex.getClass().getCanonicalName());
        return "error";
    }

}