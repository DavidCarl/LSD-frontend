package com.zee.servlets;

import com.zee.servlets.backendconnector.BackendConnectable;
import com.zee.servlets.web.viewmodels.OffersPageVM;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@WebServlet("/OfferServlet")
public class OfferServlet extends HttpServlet {

    // ejb:/4/ContractBean!contract.interfaces.BeanInterface
    //@EJB//(lookup = "ejb://DevConnector!com.zee.servlets.backendconnector.BackendConnectable")
    @EJB(name = "DevConnector", beanName = "DevConnector")
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
            OffersPageVM viewModel = connector.getOffersPageData(new Date(1000, 02, 2), new Date(2939, 02, 2), fromAiport, toAirport, true);
            System.out.println("It worked");
            System.out.println(viewModel.toString());
            request.setAttribute("viewModel", viewModel);
            request.getRequestDispatcher("flightDeals.jsp").forward(request, response);
            response.sendRedirect("flightDeals.jsp");

        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            String fromAiport = request.getParameter("fromAirport");
//            String toAirport = request.getParameter("toAirport");
//            String departDate = request.getParameter("depDate");
//            String returnDate = request.getParameter("retDate");
//            String adultsNumber = request.getParameter("adultNumber");
//            System.out.println("we are her from offer servlet");
//            System.out.println(fromAiport + " " + toAirport+ " "+ departDate + " " + returnDate+ " "+ adultsNumber );
//            System.out.println(connector.hello("Bob"));
//            OffersPageVM page = connector.getOffersPageData(new Date(1000, 02, 2), new Date(2939, 02, 2), fromAiport, toAirport, true);
//            System.out.println("It worked");
//            System.out.println(page.toString());
//            request.setAttribute("page", page);
//            request.getRequestDispatcher("flightDeals.jsp").forward(request, response);
//            response.sendRedirect("flightDeals.jsp");
//
//        } catch (Throwable theException) {
//            System.out.println(theException);
//        }
//    }
}
