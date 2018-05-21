package com.ws.impl;


import com.ws.HelloCxf;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component
@WebService(endpointInterface = "com.ws.HelloCxf" ,serviceName = "HelloCxf")
public class HelloCxfImpl implements HelloCxf {

    @Override
    public String sayHello() throws Exception {

        String str = "Hello World";
        System.out.println(str);
        return str;
    }
}
