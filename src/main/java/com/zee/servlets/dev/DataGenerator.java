package com.zee.servlets.dev;

import contract.dto.*;

import java.util.*;

public class DataGenerator {
    public static User genUser() {
        return new  User(1, 1234, "Mo","123" );
    }

    public static Flight[] genFlights() {
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

    public static FlightRoute[] genFlightRoutes() {
        Flight[] flights = genFlights();

        FlightRoute[] routes = new FlightRoute[3];

        ArrayList<Flight> flight1 = new ArrayList<>();
        flight1.add(flights[0]);
        routes[0] = new FlightRoute(true, flight1);
        //new rout from Barcelona to Malmø
        ArrayList<Flight> flight2 = new ArrayList<>();
        flight2.add(flights[1]);
        flight2.add(flights[2]);
        routes[1] = new FlightRoute(false, flight2);
        //new rout
        ArrayList<Flight> flight3 = new ArrayList<>();
        flight3.add(flights[2]);
        routes[2] = new FlightRoute(true, flight3);
        return routes;
    }

    public static FlightOffer[] genFlightOffers(boolean oneWay) {
        FlightOffer[] offers = new FlightOffer[4];
        FlightRoute[] routes = genFlightRoutes();
        offers[0] = new FlightOffer(3333.2, false, routes[1], routes[0]);
        System.out.println(offers[0]);
        offers[1] = new FlightOffer(11341.1, true, routes[2], routes[0]);
        offers[2] = new FlightOffer(123300.2, true, routes[0], routes[2]);
        offers[3] = new FlightOffer(19938.90, false, routes[2], routes[1]);
        for (FlightOffer o : offers) {
            o.setOneWay(oneWay);
            if (oneWay) o.setReturnRoute(null);
        }
        return offers;
    }

    public static ArrayList<FlightOffer> genFlightOffersAList(boolean oneWay){
        return new ArrayList<>(Arrays.asList(DataGenerator.genFlightOffers(oneWay)));
    }
    
    public static Booking genBooking(){
        PNRIdentifier pnr = new PNRIdentifier(1);
        FFNCCIdenitfier ffncc = new FFNCCIdenitfier("2000102323");
        Passenger passenger = new Passenger("Mikkel", "Hansen", new Date(1995, 06, 30));
        ArrayList<Ticket> tickets = new ArrayList<>();
        Flight[] flights = genFlights();
        Ticket ticket = new Ticket(passenger,flights[0]);
        tickets.add(ticket);
        
        FlightRoute[] flightroute = genFlightRoutes();
        
        Booking booking = new Booking(pnr, 2000.00, ffncc, tickets, flightroute[0], flightroute[1]);
        return booking;
    }
    
}
