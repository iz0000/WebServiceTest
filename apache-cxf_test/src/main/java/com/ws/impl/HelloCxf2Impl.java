package com.ws.impl;

import com.ws.HelloCxf2;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@WebService(endpointInterface = "com.ws.HelloCxf2" ,serviceName = "HelloCxf2")
public class HelloCxf2Impl implements HelloCxf2 {

    @Override
    public String printDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

        return sdf.format(new Date());
    }

}
