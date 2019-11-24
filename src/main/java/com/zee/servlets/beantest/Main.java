package com.zee.servlets.beantest;

import com.zee.servlets.backendconnector.EndpointFactory;
import contract.interfaces.BeanInterface;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.io.FileSystemResource;

import javax.ejb.EJB;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
////        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/services.xml"));
////        IBeanService service = (IBeanService) factory.getBean("bob");
//        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
//        IBeanService service = (IBeanService) context.getBean("bob");
//
////        Bob service = new Bob();
//        service.bob();

//        EndpointFactory factory = new EndpointFactory();
//        BeanInterface endpoint = factory.getEndpoint();
//
//        String response = endpoint.whoAmI("rasmus");
//        System.out.println(response);
    }
}
