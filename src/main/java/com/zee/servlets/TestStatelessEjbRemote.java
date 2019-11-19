package com.zee.servlets;

import javax.ejb.Remote;

@Remote
public interface TestStatelessEjbRemote {
    String sayHello(String name);
}