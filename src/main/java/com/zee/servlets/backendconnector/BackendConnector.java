package com.zee.servlets.backendconnector;

import com.zee.servlets.web.viewmodels.*;
import contract.dto.FlightOffer;
import contract.dto.FlightRoute;
import contract.interfaces.BeanInterface;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BackendConnector implements BackendConnectable {

    private BeanInterface endpoint;

    public BackendConnector(UserVM user) {
        this.endpoint = new EndpointFactory().getEndpoint(user);
    }

    public BackendConnector(BeanInterface endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String hello(String s) {
        String response = endpoint.whoAmI(s);
        return response;
    }

    @Override
    public OffersPageVM getOffersPageData(UserVM user, Date start, Date end, String depIata, String destIata, boolean oneWay) {
        Collection<FlightOffer> offers = endpoint.getFlightOffers(DTOConvert.fromUserVm(user), start, end, depIata, destIata, oneWay);
        ArrayList<OfferVM> offerVms = new ArrayList<>();
        for (FlightOffer offerDto : offers) {
            offerVms.add(DTOConvert.toOfferVm(offerDto));
        }
        ArrayList<FlightVM> flights = offerVms.get(0).getOutFlights();
        AirportVM depAirport = flights.get(0).getDepAirport();
        AirportVM destAirport = flights.get(flights.size() - 1).getArrAirport();

        return new OffersPageVM(
                start,
                end,
                depAirport,
                destAirport,
                oneWay,
                offerVms
        );
    }
}
