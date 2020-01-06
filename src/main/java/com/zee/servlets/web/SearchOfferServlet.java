package com.zee.servlets.web;

import com.zee.servlets.backendconnector.BackendConnectable;
import com.zee.servlets.backendconnector.BackendConnector;
import com.zee.servlets.backendconnector.DTOConvert;
import com.zee.servlets.backendconnector.UnknownBackendException;
import com.zee.servlets.web.viewmodels.OffersPageVM;
import com.zee.servlets.web.viewmodels.UserVM;
import contract.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SearchOfferServlet")
public class SearchOfferServlet extends HttpServlet {
    private BackendConnectable connector;

    public SearchOfferServlet() {
    }

    public SearchOfferServlet(BackendConnectable connector) {
        this.connector = connector;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fromAiport = request.getParameter("fromAirport");
            String fromApIata = fromAiport.substring(0, 3);

            System.out.println(fromAiport);
            System.out.println(fromApIata);
            String toAirport = request.getParameter("toAirport");
            String toApIata = toAirport.substring(0, 3);
            String departDate = request.getParameter("depDate");
            String returnDate = request.getParameter("retDate");
            Date depDate = new SimpleDateFormat("MM/dd/yyyy").parse(departDate);
            Date reDate = new SimpleDateFormat("MM/dd/yyyy").parse(returnDate);
            boolean oneWay = Boolean.parseBoolean(request.getParameter("oneWayVal"));
            System.out.println("dep" + " " + depDate + " " + "redate" + " " + reDate);
            System.out.println(fromAiport + " " + toAirport + " " + departDate + " " + returnDate + " " + oneWay);
            HttpSession session = request.getSession();
            UserVM user = DTOConvert.toUserVm((User) session.getAttribute("currentSessionUser"));
            System.out.println("user: " + user);
            connector = new BackendConnector();
            OffersPageVM viewModel = connector.getOffersPageData(user, depDate, reDate, fromApIata, toApIata, oneWay);
                System.out.println(viewModel.toString());
                session.setAttribute("offerDtos", viewModel.getOfferDtos());
                request.setAttribute("viewModel", viewModel);
                request.getRequestDispatcher("flightDeals.jsp").forward(request, response);
                response.sendRedirect("flightDeals.jsp");

        } catch (ParseException theException) {
            response.sendError(400, "Wrong date format");
            return;
        }
        catch (UnknownBackendException e){
            response.sendError(400, "No offer found!");
            return;
        }
    }
}
