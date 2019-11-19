package com.zee.servlets;
import contract.dto.*;
import contract.interfaces.BeanInterface;


import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.*;

@Stateless
public class Offers implements BeanInterface {
    @Resource
    private SessionContext context;

    @Override
    public contract.dto.User user(contract.dto.User user) {
        return null;
    }

    @Override
    public Collection<contract.dto.FlightOffer> getFlightOffers(contract.dto.User user, Date date, Date date1, String s, String s1, boolean b) {
        return null;
    }

    @Override
    public Booking makeBooking(contract.dto.User user, contract.dto.FlightOffer flightOffer, FFNCCIdenitfier ffnccIdenitfier, Collection<Passenger> collection) {
        return null;
    }

    @Override
    public Booking getBooking(contract.dto.User user, PNRIdentifier pnrIdentifier) {
        return null;
    }

    @Override
    public boolean cancelBooking(contract.dto.User user, PNRIdentifier pnrIdentifier) {
        return false;
    }

    @Override
    public String whoAmI(String message) {
        return null;
    }

}
