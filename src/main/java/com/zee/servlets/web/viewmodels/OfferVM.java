package com.zee.servlets.web.viewmodels;

import java.util.ArrayList;

public class OfferVM {
    private double price;
    private ArrayList<FlightVM> outFlights;
    private ArrayList<FlightVM> homeFlights;

    public OfferVM() {
    }

    public OfferVM(double price, ArrayList<FlightVM> outFlights, ArrayList<FlightVM> homeFlights) {
        this.price = price;
        this.outFlights = outFlights;
        this.homeFlights = homeFlights;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<FlightVM> getOutFlights() {
        return outFlights;
    }

    public void setOutFlights(ArrayList<FlightVM> outFlights) {
        this.outFlights = outFlights;
    }

    public ArrayList<FlightVM> getHomeFlights() {
        return homeFlights;
    }

    public void setHomeFlights(ArrayList<FlightVM> homeFlights) {
        this.homeFlights = homeFlights;
    }

    @Override
    public String toString() {
        return "OfferVM{" +
                "price=" + price +
                ", outFlights=" + outFlights +
                ", homeFlights=" + homeFlights +
                '}';
    }
}