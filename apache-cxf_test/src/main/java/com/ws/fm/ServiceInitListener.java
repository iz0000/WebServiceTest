package com.ws.fm;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class ServiceInitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if(event.getApplicationContext().getParent() == null){
            Map<String,Object> beans = event.getApplicationContext().getBeansWithAnnotation(WebService.class);
            System.out.println(beans.size());
            for(Object bean : beans.values()){
                Class<?> aClass = bean.getClass();
                Class<?>[] interfaces = aClass.getInterfaces();

                for(Class bClass : interfaces){
                    Annotation[] annotations = bClass.getAnnotations();
                    for(Annotation ann : annotations){
                        if (ann instanceof WebService){
                            ServerFactoryBean svrFactory = new ServerFactoryBean();
                            svrFactory.setServiceClass(bClass);
                            svrFactory.setAddress("http://127.0.0.1:8082/ws/" + bClass.getSimpleName());
                            svrFactory.setServiceBean(bean);
                            //List<Object> objects = new List<>();

                            //svrFactory.setInFaultInterceptors();
                            Server server = svrFactory.create();

                            //server.start();
                        }
                    }
                }
            }

        }
    }
}
