package com.zee.servlets.backendconnector;

import com.zee.servlets.DataGenerator;
import com.zee.servlets.web.viewmodels.OffersPageVM;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless(name = "ProdConnector")
public class ProdConnector implements BackendConnectable {
    @Override
    public String hello(String s) {
        return "Hello " + s + " from prod";
    }

    @Override
    public OffersPageVM getOffersPageData(Date start, Date end, String depIata, String destIata, boolean oneWay) {

        DataGenerator dg = new DataGenerator();



        return null;
    }
}
