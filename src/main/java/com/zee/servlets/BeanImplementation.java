/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zee.servlets;

import contract.dto.Booking;
import contract.dto.FFNCCIdenitfier;
import contract.dto.FlightOffer;
import contract.dto.PNRIdentifier;
import contract.dto.Passenger;
import contract.dto.User;
import contract.interfaces.BeanInterface;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Mikkel
 */
public class BeanImplementation implements BeanInterface {

    @Override
    public User user(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<FlightOffer> getFlightOffers(User user, Date date, Date date1, String string, String string1, boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Booking makeBooking(User user, FlightOffer fo, FFNCCIdenitfier ffncci, Collection<Passenger> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Booking getBooking(User user, PNRIdentifier pnri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cancelBooking(User user, PNRIdentifier pnri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String whoAmI(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
