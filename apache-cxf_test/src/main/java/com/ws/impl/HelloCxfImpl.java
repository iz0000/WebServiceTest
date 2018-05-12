package com.ws.impl;


import com.ws.HelloCxf;

public class HelloCxfImpl implements HelloCxf {

    @Override
    public String sayHello() throws Exception {

        String str = "Hello World";
        System.out.println("str");
        return str;
    }
}
