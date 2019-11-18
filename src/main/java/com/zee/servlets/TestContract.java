package com.zee.servlets;

import contract.dto.*;
import contract.dto.FlightOffer;

import java.util.*;

public class TestContract {

    public static void main(String[] args) {

        //     Collection<Offers> getFlightOffers(Date start, Date end, String depIata, String destIata, boolean oneWay);
     Offers offer = new Offers();
     offer.getFlightOffers(new Date(), new Date(),"", "", false );



    }
}
