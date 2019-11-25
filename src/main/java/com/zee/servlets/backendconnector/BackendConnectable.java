package com.zee.servlets.backendconnector;

import com.zee.servlets.web.viewmodels.OffersPageVM;
import com.zee.servlets.web.viewmodels.UserVM;
import contract.dto.*;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.Date;

@Local
public interface BackendConnectable {
    String hello(String s);
    UserVM userLogin(String username, String password, int agencyNumber);
    OffersPageVM getOffersPageData(UserVM user, Date start, Date end, String depIata, String destIata, boolean oneWay);
    boolean createBooking(UserVM user, FlightOffer flightOffer, String ffncc, ArrayList<Passenger> passengers);
    boolean cancelBooking(User user, PNRIdentifier pnr);
    Booking getBooking(User user, long pnr);
}
