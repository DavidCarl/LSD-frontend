package com.zee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import classes.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            String usernameInput = request.getParameter("user");
            String passwordInput = request.getParameter("pw");
            if (usernameInput != null) {
                System.out.println("ses");
                //User user = new User(1,105,usernameInput,passwordInput);
                System.out.println("med");
                //System.out.println(user.toString());
                //HttpSession session = request.getSession();
                //session.setAttribute("currentSessionUser", user);
                //System.out.println("who logged in ? :"+session.getAttribute("currentSessionUser"));
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("fuckoff.jsp"); //error page
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