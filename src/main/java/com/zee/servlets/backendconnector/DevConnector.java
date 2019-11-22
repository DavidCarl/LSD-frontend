package com.zee.servlets.backendconnector;

import javax.ejb.Local;

@Local
public class DevConnector implements BackendConnectable {
    @Override
    public String hello(String s) {
        return "Hello " + s;
    }
}
