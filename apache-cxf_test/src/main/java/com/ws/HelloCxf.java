package com.ws;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component
@WebService
public interface HelloCxf {

    @WebMethod
    String sayHello() throws Exception;

}
