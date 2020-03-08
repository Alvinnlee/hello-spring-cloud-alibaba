package com.funtl.spring.cloud.alibaba.consumer.configure;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class FileContext implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {

        ResponseDate responseDate = null;
        response.setContentType( "application/json;charset=utf-8");

        if( e instanceof FlowException ){
            responseDate = new ResponseDate(-1,"限流");
        }else if( e instanceof DegradeException){
            responseDate = new ResponseDate(-1,"降级");
        }
        else if( e instanceof ParamFlowException){
            responseDate = new ResponseDate(-1,"参数限流");
        }
        else if( e instanceof AuthorityException){
            responseDate = new ResponseDate(-1,"授权异常");
        }

        response.getWriter().write(JSON.toJSONString( responseDate ));

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ResponseDate{
    Integer id;
    String message;
}
