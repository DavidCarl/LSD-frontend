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
import contract.dto.Flight;
import contract.dto.Airplane;
import contract.dto.Airport;
import contract.dto.Passenger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
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
            Flight flight = new Flight(0, depDate, depDate, airplane, airportFrom, airportTo);
            System.out.println(destinationFrom + " - " + destinationTo + " - " + departDate + " - " + returnDate);
            
            int amountOfPeople = Integer.parseInt(request.getParameter("adults")) + Integer.parseInt(request.getParameter("children"));
           
            ArrayList<Passenger> passengerList = new ArrayList<>();
            for (int i = 0; i < amountOfPeople; i++){
                String firstname = request.getParameter("firstnameid"+i);
                String lastname = request.getParameter("lastnameid"+i);
                String dobString = request.getParameter("dobid"+i);
                Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dobString);
                Passenger p = new Passenger(firstname, lastname, dob);
                passengerList.add(p);
            }
            for (int i = 0; i < passengerList.size(); i++) {
                System.out.println(passengerList.get(i).toString());
            }
            
            
     
        } catch (Throwable theException) {
            System.out.println(theException);
        }
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


