package com.zee.servlets.dev;

import contract.dto.*;
import contract.interfaces.BeanInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DevEndpoint implements BeanInterface {
    @Override
    public User user(User user) {
        return null;
    }

    @Override
    public Collection<FlightOffer> getFlightOffers(User user, Date start, Date end, String depIata, String destIata, boolean oneWay) {
        ArrayList<FlightOffer> offers = DataGenerator.genFlightOffersAList(oneWay);
        return offers;
    }

    @Override
    public Booking makeBooking(User user, FlightOffer flightOffer, FFNCCIdenitfier ffnccIdenitfier, Collection<Passenger> collection) {
        return null;
    }

    @Override
    public Booking getBooking(User user, PNRIdentifier pnrIdentifier) {
        return null;
    }

    @Override
    public boolean cancelBooking(User user, PNRIdentifier pnrIdentifier) {
        return false;
    }

    @Override
    public String whoAmI(String s) {
        return "Hello, " + s + " I am dev endpoint!";
    }
}
