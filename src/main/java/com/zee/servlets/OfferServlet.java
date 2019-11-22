package com.zee.servlets;

import com.zee.servlets.backendconnector.BackendConnectable;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OfferServlet")
public class OfferServlet extends HttpServlet {

    @EJB
    private BackendConnectable connector;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fromAiport = request.getParameter("fromAirport");
            String toAirport = request.getParameter("toAirport");
            String departDate = request.getParameter("depDate");
            String returnDate = request.getParameter("retDate");
            String adultsNumber = request.getParameter("adultNumber");
            System.out.println("we are her from offer servlet");
            System.out.println(fromAiport + " " + toAirport+ " "+ departDate + " " + returnDate+ " "+ adultsNumber );
            System.out.println(connector.hello("Bob"));
            response.sendRedirect("flightDeals.jsp");

        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
