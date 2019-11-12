package com.zee.servlets;

import contract.dto.*;
import contract.interfaces.BeanInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class DumeData {
    Date date1 = new Date(2019,02,3);
    Date date2 = new Date(2019,03,2);




    FlightRoute flightr1 = new FlightRoute();


    ArrayList<FlightRoute> flight = new ArrayList<FlightRoute>(
            Arrays.asList(new FlightRoute())
    );

}
