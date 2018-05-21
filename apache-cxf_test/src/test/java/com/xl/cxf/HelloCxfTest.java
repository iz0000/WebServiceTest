package com.xl.cxf;

import com.ws.HelloCxf;
import com.ws.impl.HelloCxfImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

public class HelloCxfTest {


    @Test
    public void test1() throws Exception{
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloCxf.class);
        factory.setAddress("http://192.168.154.1/ws/helloCxf?wsdl");
        HelloCxf cxf = (HelloCxf)factory.create();
        String s = cxf.sayHello();
        System.out.println("" + s);
    }

    @Test
    public void test2() throws Exception{
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        QName qName = new QName("http://impl.ws.com/","sayHello");
        Client client = dcf.createClient("http://localhost:8081/ws/HelloCxfImpl?wsdl");

        Object[] res = client.invoke(qName);
        System.out.println("Echo response: " + res[0]);
    }

    /*
    @Test
    public void test3(){
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress("http://localhost:8080/facelook/services/facelookWebService?wsdl");
        QName qName = new QName("http://server.webservice.facelook.com/", "getAlbumList");
        call.setOperationName(qName);
        call.setUseSOAPAction(true);

        call.addParameter("xmlStr", XMLType.XSD_STRING, ParameterMode.IN);
        call.setReturnType(XMLType.XSD_STRING);
        String result = (String) call.invoke(new Object[] { xmlStr });
        System.out.println(result);
    }
    */

    @Test
    public void test4() throws Exception {
        DynamicClientFactory clientFactoryBean = DynamicClientFactory.newInstance();
        Client client = clientFactoryBean.createClient("http://127.0.0.1:8082/ws/HelloCxf2?wsdl");
        Object[] sayHellos = client.invoke("printDateTime");
        System.out.println(sayHellos[0]);
    }

    @Test
    public void test5() throws ClassNotFoundException, InterruptedException {
        ServerFactoryBean svrFactory = new ServerFactoryBean();
        Class serviceClass = Class.forName("com.ws.impl.HelloCxfImpl");
        svrFactory.setServiceClass(serviceClass);
        svrFactory.setAddress("http://localhost:8081");
        svrFactory.setServiceBean(HelloCxf.class);
        Server server = svrFactory.create();

    }

}
