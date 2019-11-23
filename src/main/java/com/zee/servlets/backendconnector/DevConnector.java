package com.zee.servlets.backendconnector;

import com.zee.servlets.DataGenerator;
import com.zee.servlets.web.viewmodels.AirportVM;
import com.zee.servlets.web.viewmodels.OfferVM;
import com.zee.servlets.web.viewmodels.OffersPageVM;
import contract.dto.*;
import contract.interfaces.BeanInterface;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Stateless(name = "DevConnector")
public class DevConnector implements BackendConnectable {

    @Override
    public String hello(String s) {
        return "Hello " + s + " from dev";
    }

    @Override
    public OffersPageVM getOffersPageData(Date start, Date end, String depIata, String destIata, boolean oneWay) {
        ArrayList<OfferVM> offers = new ArrayList<>();
        for (FlightOffer offer : DataGenerator.genFlightOffers()) {
            System.out.println("offer: " + offer);
            offers.add(DTOConvert.toOfferVm(offer));
        }
        AirportVM depAirport = offers.get(0).getOutFlights().get(0).getDepAirport();
        AirportVM destAirport = offers.get(0).getOutFlights().get(offers.get(0).getOutFlights().size() -1).getArrAirport();

        return new OffersPageVM(
                start,
                end,
                depAirport,
                destAirport,
                oneWay,
                offers
        );
    }

    public static void main(String[] args) {
        new DevConnector().getOffersPageData(new Date(1000, 02, 2), new Date(2939, 02, 2), "bob", "bob2", true);
    }
}
