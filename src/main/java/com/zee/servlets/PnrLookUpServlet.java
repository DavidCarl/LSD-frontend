package com.zee.servlets;

import com.zee.servlets.dev.DevEndpoint;
import contract.dto.Booking;
import contract.dto.PNRIdentifier;
import contract.dto.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

@WebServlet("/PnrLookUpServlet")
public class PnrLookUpServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Booking booking = (Booking) session.getAttribute("booking");
        User user = (User) session.getAttribute("user");
        DevEndpoint devend = new DevEndpoint();
        boolean boo = devend.cancelBooking(user, booking.getPnr());
        session.setAttribute("booking", null);
        
        RequestDispatcher requestDispatcher = request
         .getRequestDispatcher("home.jsp");
         requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DevEndpoint devend = new DevEndpoint();
        User user = (User) session.getAttribute("user");
        PNRIdentifier pnr = null;
        try {
            long pnrLong = Long.parseLong(request.getParameter("pnr"));
            pnr = new PNRIdentifier(pnrLong);
            Booking booking = devend.getBooking(user, pnr);

            if (booking != null) {
                session = request.getSession();
                session.setAttribute("booking", booking);
            } else {
                session = request.getSession();
                session.setAttribute("booking", null);
            }
        } catch (Exception e) {
            session = request.getSession();
            session.setAttribute("booking", null);

        }

        RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);
    }

}
