package com.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloCxf {

    @WebMethod
    String sayHello() throws Exception;

}
