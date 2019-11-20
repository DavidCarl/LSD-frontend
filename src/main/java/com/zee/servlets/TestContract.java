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

    public void loadProperties(String h, String p) {
        try {
            System.out.println("h: " + h + " p: " + p);

            Properties prop = new Properties();
            prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080"); //backend.dcarl.me

            prop.put("jboss.naming.client.ejb.context", false);

            ic = new InitialContext(prop);
        } catch (NamingException ex) {
            Logger.getLogger(TestContract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String a[]) {

        try {
            final String appName = "https://www.backend.dcarl.me";
            final String moduleName = "spring-ejb-remote";
            final String distinctName = "";
            final String beanName = "Backend";
            final String viewClassName = BeanInterface.class.getName();
            final String toLookup = String.format("ejb:%s/%s/%s/%s!%s", appName, moduleName, distinctName, beanName, viewClassName);
            new TestContract().loadProperties("https://www.backend.dcarl.me", "80");
            BeanInterface etr = (BeanInterface) ic.lookup("ejb:/backend/ContractBean!contract.interfaces.BeanInterface"); //ejb:/www.backend.me//ContractBean!
            System.out.println(etr.whoAmI("David"));

            Date now = new Date(1,1,1);
            User user = new User(1,1,"a","a");

            Collection<FlightOffer> offers = etr.getFlightOffers(user, now, now, "bla", "bla", true);

            for (FlightOffer fo : offers) {
                for (Flight f : fo.getOutRoute().getFlights()) {
                    System.out.println(f.getId());
                    System.out.println(f.getArrAirport().getName());
                }
                System.out.println(fo.isOneWay());
                System.out.println(fo.getPrice());
            }

        } catch (NamingException ex) {
            System.out.println(ex);
        }
    }
}