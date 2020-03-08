package com.funtl.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RefreshScope
public class EchoController {


    @Value("${server.port}")
    private String port;

    int a = 1;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {

        /*try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        a++;
        System.out.println(a);
        if ( a== 2){
            return "Hello Nacos Provider " + a;
        }
        return "Hello Nacos Provider " + a;
    }

    @RequestMapping(value = "a")
    public Object a( String bb) {

        Map<Object, Object> map = new HashMap<>();
        map.put("bod","你好");
        map.put("states", 200);
        return map;
    }

    @RequestMapping(value = "b")
    public Object a1( @RequestBody MultiValueMap map) {
        System.out.println(map);
        return "nnnn";
    }

    @RequestMapping(value = "c")
    public Object a12( @RequestBody String map) {
        System.out.println(map);
        return "nnnn";
    }
}
