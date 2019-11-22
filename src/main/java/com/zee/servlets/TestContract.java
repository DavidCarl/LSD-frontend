package com.zee.servlets;


import contract.dto.Flight;
import contract.dto.FlightOffer;
import contract.dto.User;
import contract.interfaces.BeanInterface;

import java.util.Collection;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Remote
public class TestContract {

    private static InitialContext ic;
    //private String host="",port="";

    public static void main(String[] a) {

        try {
            final String appName = "https://www.backend.dcarl.me";
            final String moduleName = "spring-ejb-remote";
            final String distinctName = "";
            final String beanName = "Backend";
            final String viewClassName = BeanInterface.class.getName();
            final String toLookup = String.format("ejb:%s/%s/%s/%s!%s", appName, moduleName, distinctName, beanName, viewClassName);
            new TestContract().loadProperties("https://www.backend.dcarl.me", "80");
            BeanInterface etr = (BeanInterface) ic.lookup("ejb:/4/ContractBean!contract.interfaces.BeanInterface"); //ejb:/4/ContractBean!contract.interfaces.BeanInterface
            System.out.println(etr.whoAmI("Mo"));
        } catch (NamingException ex) {
            System.out.println(ex);
        }
    }

    public void loadProperties(String h, String p) {
        try {
            System.out.println("h: " + h + " p: " + p);

            Properties prop = new Properties();
            prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            prop.put(Context.PROVIDER_URL, "http-remoting://backend.dcarl.me:8082"); //http-remoting://backend.dcarl.me:8082

            prop.put("jboss.naming.client.ejb.context", false);

            ic = new InitialContext(prop);
        } catch (NamingException ex) {
            Logger.getLogger(TestContract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}