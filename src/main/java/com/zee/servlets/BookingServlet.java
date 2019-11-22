package com.zee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import contract.dto.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.function.Consumer;
import javax.servlet.RequestDispatcher;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        String page = "errorpage.jsp";
        try {
            
            Double price = Double.parseDouble(request.getParameter("price"));
            String ffnccParameter = request.getParameter("ffncc");  
            String destinationFrom = request.getParameter("autocompletefrom");
            String destinationTo = request.getParameter("autocompleteto");
            String departDate = request.getParameter("departDate");
            String returnDate = request.getParameter("returnDate");
            Date depDate = new SimpleDateFormat("MM/dd/yyyy").parse(departDate); 
            Date reDate = new SimpleDateFormat("MM/dd/yyyy").parse(returnDate);  
            Calendar calendar = new GregorianCalendar();
            TimeZone timeZone = calendar.getTimeZone();
            Airport airportFrom = new Airport(timeZone, "COP", "COPENHAGEN AIRPORT");
            Airport airportTo = new Airport(timeZone, "MD", "MADRID AIRPORT");
            Airplane airplane = new Airplane(100, "SESNOOB");
            Flight departureFlight = new Flight(0, depDate, depDate, airplane, airportFrom, airportTo);
            Flight returnFlight = new Flight(0, reDate, reDate, airplane, airportTo, airportFrom);
            ArrayList<Flight> departureFlights = new ArrayList<>();
            departureFlights.add(departureFlight);
           
            ArrayList<Flight> returnFlights = new ArrayList<>();
            returnFlights.add(returnFlight);
            
            FlightRoute departureRoute = new FlightRoute(true, departureFlights);
            FlightRoute returnRoute = new FlightRoute(true, returnFlights);
            
            System.out.println(destinationFrom + " - " + destinationTo + " - " + departDate + " - " + returnDate);
            
            int amountOfPeople = Integer.parseInt(request.getParameter("adults")) + Integer.parseInt(request.getParameter("children"));
            System.out.println(amountOfPeople);
           
            ArrayList<Passenger> passengerList = new ArrayList<>();
            for (int i = 0; i < amountOfPeople; i++){
                System.out.println(request.toString());
                String firstname = request.getParameter("firstname"+i);
                String lastname = request.getParameter("lastname" +i);
                String dobString = request.getParameter("dob" +i);
                System.out.println(firstname + " -- " + lastname + " -- " + dobString);
                Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dobString);
                Passenger p = new Passenger(firstname, lastname, dob);
                passengerList.add(p);
            }
            ArrayList<Ticket> ticketList = new ArrayList<>();
            for (int i = 0; i < passengerList.size(); i++) {
                Ticket ticket = new Ticket(passengerList.get(i), departureFlight);
                ticketList.add(ticket);
                System.out.println(passengerList.get(i).toString());
            }
            PNRIdentifier pnrfinal = new PNRIdentifier(1232432);
            FFNCCIdenitfier ffncc = new FFNCCIdenitfier(ffnccParameter);
            Booking myfavoritebooking = new Booking(pnrfinal, price, ffncc, ticketList, departureRoute, returnRoute);
            
            HttpSession session = request.getSession();
            session.setAttribute("booking", myfavoritebooking);
            
            page = "singlebooking.jsp";

                    
        } catch (Throwable theException) {
            System.out.println(theException);
        }
            RequestDispatcher requestDispatcher = request
             .getRequestDispatcher(page);
              requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("servletName", "start.jsp");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("it works m8, can u hear me ");
        out.println("</body></html>");
    }
     
}


