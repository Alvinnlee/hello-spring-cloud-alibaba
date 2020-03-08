package com.funtl.spring.cloud.alibaba.consumer.configure;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class RequestOrigin implements RequestOriginParser {

    //区分来源
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String id = request.getParameter("id");
//        if(StringUtils.isEmpty( id) ){
//            throw new RuntimeException("mmmmmmmmm");
//        }
        return id ;

//        return "ok";
    }
}
