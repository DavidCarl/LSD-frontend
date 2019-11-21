package com.zee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import contract.dto.User;
import java.util.ArrayList;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    ArrayList<User> users;

    public void initialUsers() {
        users = new ArrayList<User>();
        users.add(new User(1, 105, "admin", "admin"));
        users.add(new User(2, 151, "testuser", "test"));

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            initialUsers();
            String usernameInput = request.getParameter("user");
            String passwordInput = request.getParameter("pw");
            if (usernameInput != null && passwordInput != null) {
                for (int i = 0; i < users.size(); i++) {
                    if (usernameInput.equals(users.get(i).getUserName()) && passwordInput.equals(users.get(i).getPassword())) {
                        HttpSession session = request.getSession();
                        session.setAttribute("currentSessionUser", users.get(i));
                        System.out.println("who logged in: " + session.getAttribute("currentSessionUser"));
                        response.sendRedirect("home.jsp");
                    } else {
                        response.sendRedirect("errorpage.jsp"); //error page
                    }
                }
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
