package com.zee.servlets.web.viewmodels;

import contract.dto.FlightOffer;

import java.util.ArrayList;
import java.util.Date;

public class OffersPageVM {
    private Date travelDate;
    private Date homeDate;
    private AirportVM depAirport;
    private AirportVM arrAirport;
    private boolean oneWay;
    private ArrayList<OfferVM> offers;
    private ArrayList<FlightOffer> offerDtos;

    public OffersPageVM() {
    }

    public OffersPageVM(Date travelDate, Date homeDate, AirportVM depAirport, AirportVM arrAirport, boolean oneWay, ArrayList<OfferVM> offers, ArrayList<FlightOffer> offerDtos) {
        this.travelDate = travelDate;
        this.homeDate = homeDate;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.oneWay = oneWay;
        this.offers = offers;
        this.offerDtos = offerDtos;
    }

    public Date getTravelDate() {
        return travelDate;
    }
    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }
    public Date getHomeDate() {
        return homeDate;
    }
    public void setHomeDate(Date homeDate) {
        this.homeDate = homeDate;
    }
    public AirportVM getDepAirport() {
        return depAirport;
    }
    public void setDepAirport(AirportVM depAirport) {
        this.depAirport = depAirport;
    }
    public AirportVM getArrAirport() {
        return arrAirport;
    }
    public void setArrAirport(AirportVM arrAirport) {
        this.arrAirport = arrAirport;
    }
    public boolean isOneWay() {
        return oneWay;
    }
    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }
    public ArrayList<OfferVM> getOffers() {
        return offers;
    }
    public void setOffers(ArrayList<OfferVM> offers) {
        this.offers = offers;
    }
    public ArrayList<FlightOffer> getOfferDtos() {
        return offerDtos;
    }
    public void setOfferDtos(ArrayList<FlightOffer> offerDtos) {
        this.offerDtos = offerDtos;
    }

    @Override
    public String toString() {
        return "OffersPageVM{" +
                "travelDate=" + travelDate +
                ", homeDate=" + homeDate +
                ", depAirport=" + depAirport +
                ", arrAirport=" + arrAirport +
                ", oneWay=" + oneWay +
                ", offers=" + offers +
                '}';
    }
}
