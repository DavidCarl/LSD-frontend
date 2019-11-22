package com.zee.servlets.web.viewmodels;

import java.util.ArrayList;

public class OfferVM {
    private double price;
    private boolean oneWay;
    private ArrayList<FlightVM> outFlights;
    private ArrayList<FlightVM> homeFlights;

    public OfferVM() {
    }

    public OfferVM(double price, boolean oneWay, ArrayList<FlightVM> outFlights, ArrayList<FlightVM> homeFlights) {
        this.price = price;
        this.oneWay = oneWay;
        this.outFlights = outFlights;
        this.homeFlights = homeFlights;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isOneWay() {
        return oneWay;
    }
    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
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
                ", oneWay=" + oneWay +
                ", outFlights=" + outFlights +
                ", homeFlights=" + homeFlights +
                '}';
    }
}