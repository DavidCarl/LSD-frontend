package com.zee.servlets.backendconnector;

import com.zee.servlets.web.viewmodels.*;
import contract.dto.*;
import contract.interfaces.BeanInterface;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class BackendConnector implements BackendConnectable {

    private BeanInterface endpoint;

    public BackendConnector() {
        this.endpoint = new EndpointFactory().getEndpoint();
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
    public UserVM userLogin(String username, String password, int agencyNumber) {
        User loginObj = new User();
        loginObj.setUserName(username);
        loginObj.setPassword(password);
        loginObj.setAgencyNumber(agencyNumber);
        User loggedInUser = endpoint.user(loginObj);
        return DTOConvert.toUserVm(loggedInUser);
    }

    @Override
    public OffersPageVM getOffersPageData(UserVM user, Date start, Date end, String depIata, String destIata, boolean oneWay) throws UnknownBackendException {
        Collection<FlightOffer> offers = endpoint.getFlightOffers(DTOConvert.fromUserVm(user), start, end, depIata, destIata, oneWay);
        if (offers == null) throw new UnknownBackendException("Backend returned null");
        Iterator<FlightOffer> it = offers.iterator();
        if (it.hasNext()) {
            FlightOffer dto = it.next();
            if (dto.getOutRoute().getFlights().size() <= 0)
                throw new UnknownBackendException("Backend returned offer with no flights");
        } else {
            throw new UnknownBackendException("Backend returned 0 offers");
        }
        System.out.println("offers");
        System.out.println(offers.size());
        ArrayList<OfferVM> offerVms = new ArrayList<>();
        for (FlightOffer offerDto : offers) {
            System.out.println(offerDto.getPrice());
            System.out.println(offerDto.getOutRoute().getFlights().size());
            System.out.println(offerDto.getReturnRoute().getFlights().size());
            offerVms.add(DTOConvert.toOfferVm(offerDto));
        }
        ArrayList<FlightVM> flights = offerVms.get(0).getOutFlights();
        System.out.println(flights.size());
        AirportVM depAirport = flights.get(0).getDepAirport();
        System.out.println("222222222222222222222"+flights);
        AirportVM destAirport = flights.get(flights.size() - 1).getArrAirport();

        return new OffersPageVM(
                start,
                end,
                depAirport,
                destAirport,
                oneWay,
                offerVms,
                new ArrayList<>(offers)
        );
    }

    @Override
    public boolean createBooking(UserVM user, FlightOffer flightOffer, String ffncc, ArrayList<Passenger> passengers) {
        User userDto = DTOConvert.fromUserVm(user);
        FFNCCIdenitfier ffnccId = new FFNCCIdenitfier(ffncc);
        Booking booking = endpoint.makeBooking(userDto, flightOffer, ffnccId, passengers);
        if(booking != null) return true;
        return false;
    }

    @Override
    public boolean cancelBooking(User user, PNRIdentifier pnr) {
        boolean result = endpoint.cancelBooking(user, pnr);
        return result;
    }

    @Override
    public Booking getBooking(User user, long pnr) {
        Booking booking = endpoint.getBooking(user, new PNRIdentifier(pnr));
        return booking;
    }
}
