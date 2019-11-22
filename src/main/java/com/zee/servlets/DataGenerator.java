package com.zee.servlets;

import contract.dto.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class DataGenerator {
    public static User genUser() {
        return new  User(1, 1234, "Mo","123" );
    }

    public static Flight[] genFlight() {
        Flight[] flights = new Flight[4];
        flights[0] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "SKF"),
                new Airport(TimeZone.getTimeZone("GMT"), "CPH", "Copenhagen"),
                new Airport(TimeZone.getTimeZone("GMT"), "NY", "New York")
        );
        flights[1] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "KOD"),
                new Airport(TimeZone.getTimeZone("GMT"), "MLM", "Malmø"),
                new Airport(TimeZone.getTimeZone("GMT"), "MLG", "Malaga")
        );
        flights[2] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "KSF"),
                new Airport(TimeZone.getTimeZone("GMT"), "BAR", "Barcelona"),
                new Airport(TimeZone.getTimeZone("GMT"), "REY", "Reykjavik")
        );
        flights[3] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "MIU"),
                new Airport(TimeZone.getTimeZone("GMT"), "MLG", "Malaga"),
                new Airport(TimeZone.getTimeZone("GMT"), "BIL", "Billund")
        );

        return flights;
    }

    public static FlightRoute[] genFlightRoute() {
        FlightRoute[] routes = new FlightRoute[3];
        ArrayList<Flight> flight1 = new ArrayList<Flight>();
        flight1.add(genFlight()[0]);
        routes[0] = new FlightRoute(true, flight1);
        //new rout from Barcelona to Malmø
        ArrayList<Flight> flight2 = new ArrayList<Flight>();
        flight2.add(genFlight()[1]);
        flight2.add(genFlight()[2]);
        routes[1] = new FlightRoute(false, flight2);
        //new rout
        ArrayList<Flight> flight3 = new ArrayList<Flight>();
        flight2.add(genFlight()[2]);
        routes[2] = new FlightRoute(true, flight3);
        return routes;
    }

    public static FlightOffer[] genFlightOffers() {
        FlightOffer[] offers = new FlightOffer[5];
        FlightRoute[] routes = genFlightRoute();
        offers[0] = new FlightOffer(3333.2, false, routes[1], routes[0]);
        System.out.println(offers[0]);
        offers[1] = new FlightOffer(11341.1, true, routes[2], null);
        offers[2] = new FlightOffer(123300.2, true, routes[0], null);
        offers[3] = new FlightOffer(19938.90, false, routes[2], routes[1]);
        return offers;
    }


    public static ArrayList<FlightOffer> getOffer(){


        return null;
    }



    public static void main(String[] args) {
        FlightOffer gn =  genFlightOffers()[0];

        System.out.println(new ArrayList<Flight>(gn.getOutRoute().getFlights()).get(0).getDepAirport().getName());
    }
}
