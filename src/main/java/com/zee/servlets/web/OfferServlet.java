package com.zee.servlets.web;

import com.zee.servlets.backendconnector.BackendConnectable;
import com.zee.servlets.backendconnector.BackendConnector;
import com.zee.servlets.web.viewmodels.OffersPageVM;
import com.zee.servlets.web.viewmodels.UserVM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/OfferServlet")
public class OfferServlet extends HttpServlet {

    // ejb:/4/ContractBean!contract.interfaces.BeanInterface
    //@EJB//(lookup = "ejb://DevConnector!com.zee.servlets.backendconnector.BackendConnectable")

//    @EJB(name = "DevConnector", beanName = "DevConnector")
//    private BackendConnectable connector;
    private BackendConnectable connector;
    private UserVM testUser = new UserVM(2, 3, "TNT", "secresy");

    public OfferServlet() {
         connector = new BackendConnector(testUser);
    }

    public OfferServlet(BackendConnectable connector) {
        this.connector = connector;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fromAiport = request.getParameter("fromAirport");
            String toAirport = request.getParameter("toAirport");
            String departDate = request.getParameter("depDate");
            String returnDate = request.getParameter("retDate");
            Date depDate = new SimpleDateFormat("MM/dd/yyyy").parse(departDate);
            Date reDate = new SimpleDateFormat("MM/dd/yyyy").parse(returnDate);
            String adultsNumber = request.getParameter("adultNumber");
            boolean oneWay= Boolean.parseBoolean(request.getParameter("oneWayVal"));

            System.out.println("dep"+" "+depDate+" "+"redate"+ " "+ reDate);
            System.out.println(fromAiport + " " + toAirport+ " "+ departDate + " " + returnDate+ " "+ adultsNumber + " " + oneWay);
//            System.out.println(connector.hello("Frontend"));
            OffersPageVM viewModel = connector.getOffersPageData(testUser, depDate, reDate, fromAiport, toAirport, oneWay);
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
