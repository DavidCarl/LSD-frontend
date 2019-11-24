package com.zee.servlets.beantest;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod & !dev")
public class ProdBeanService implements IBeanService {
    @Override
    public void bob() {
        System.out.println("bob prod");
    }
}
