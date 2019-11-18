package com.zee.servlets;
import contract.dto.*;
import contract.interfaces.BeanInterface;

import java.util.*;


public class Offers implements BeanInterface {
    @Override
    public Collection<FlightOffer> getFlightOffers(Date start, Date end, String depIata, String destIata, boolean oneWay) {
        Flight flight = new Flight(
                2L,
                new Date(12321323L),
                new Date(1231231231231L),
                new Airplane(23, "RYAN"),
                new Airport(TimeZone.getTimeZone("00"), "CPH", "Copenhagen"),
                new Airport(TimeZone.getTimeZone("00"), "LA", "Los Angeles")
        );
        Flight flight1 = new Flight(
                2L,
                new Date(12321323L),
                new Date(1231231231231L),
                new Airplane(23, "SAS"),
                new Airport(TimeZone.getTimeZone("00"), "LA", "Los Angeles"),
                new Airport(TimeZone.getTimeZone("00"), "CPH", "Copenhagen")
        );


        List<Flight> flightCollection = new ArrayList<Flight>();
        flightCollection.add(flight);
        flightCollection.add(flight1);

        FlightRoute outRoute = new FlightRoute(true, flightCollection);




        FlightRoute returnRoute = new FlightRoute(true,flightCollection);


        FlightOffer fo = new FlightOffer(350, false, outRoute, returnRoute);

        List<FlightOffer> flightOfferCollection = new ArrayList<FlightOffer>();

        flightOfferCollection.add(fo);
        System.out.println(flightOfferCollection.get(0));
        for (int i = 0; i < flightOfferCollection.size(); i++) {
            System.out.println(flightOfferCollection.get(i));
        }
        for (FlightOffer temp : flightOfferCollection) {
            System.out.println(temp);
        }

        return  flightOfferCollection;

    }

    @Override
    public Booking makeBooking(FlightOffer offer, FFNCCIdenitfier ffncc, Collection<Passenger> passengers) {
        return null;
    }

    @Override
    public Booking getBooking(PNRIdentifier pnr) {
        return null;
    }

    @Override
    public boolean cancelBooking(PNRIdentifier pnr) {
        return false;
    }

    @Override
    public String whoAmI(String message) {
        return null;
    }
}
