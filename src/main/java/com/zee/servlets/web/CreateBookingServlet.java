package com.zee.servlets.web;

import com.zee.servlets.backendconnector.BackendConnectable;
import com.zee.servlets.backendconnector.BackendConnector;
import com.zee.servlets.backendconnector.DTOConvert;
import com.zee.servlets.web.viewmodels.UserVM;
import contract.dto.FlightOffer;
import contract.dto.Passenger;
import contract.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/CreateBookingServlet")
public class CreateBookingServlet extends HttpServlet {

    private BackendConnectable connector;

    public CreateBookingServlet() {
        connector = new BackendConnector();
    }

    public CreateBookingServlet(BackendConnectable connector) {
        this.connector = connector;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<FlightOffer> offerDtos = (ArrayList<FlightOffer>)session.getAttribute("offerDtos");
        ArrayList<Passenger> passengers = new ArrayList<>();

        int offerIndex = Integer.parseInt(request.getParameter("offerIndex"));
        int adultNo = Integer.parseInt(request.getParameter("adultNo"));
        String ffncc = request.getParameter("ffncc");

        for(int i = 0; i < adultNo; i++) {
            String dobString = request.getParameter("dob" + i);
            try {
                Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(dobString);
                String firstname = request.getParameter("firstname" + i);
                String lastName = request.getParameter("lastName" + i);
                passengers.add(new Passenger(firstname, lastName, dob));
            } catch (ParseException e) {
                response.sendError(400, "Wrong date format");
                return;
            }
        }

        UserVM user = DTOConvert.toUserVm((User)session.getAttribute("currentSessionUser"));
        boolean result = connector.createBooking(user, offerDtos.get(offerIndex), ffncc, passengers);
        if(!result) response.sendError(500);



//        System.out.println("ggggggggggggggggggggggggddddddddddddddddddd"+session.getAttribute("offerPrice"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
