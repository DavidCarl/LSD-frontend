package com.zee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /*
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            String usernameInput = request.getParameter("un");
            String passwordInput = request.getParameter("pw");
            if (usernameInput != null && usernameInput.equals("Mo") && passwordInput.equals("123")) {
                HttpSession session = request.getSession();
                session.setAttribute("currentSessionUser", usernameInput);
                //System.out.println("who logged in ? :"+session.getAttribute("currentSessionUser"));;
                response.sendRedirect("start.jsp");
            } else {
                response.sendRedirect("flightDeals.jsp"); //error page
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("servletName", "start.jsp");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("it works m8, can u hear me ");
        out.println("</body></html>");

    }
*/
}