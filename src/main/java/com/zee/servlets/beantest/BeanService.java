package com.zee.servlets.beantest;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev & !prod")
public class BeanService implements IBeanService {
    @Override
    public void bob() {
        System.out.println("Bobean dev");
    }
}
