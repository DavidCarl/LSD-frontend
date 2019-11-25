package com.zee.servlets.web;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import com.zee.servlets.backendconnector.BackendConnectable;
import com.zee.servlets.backendconnector.BackendConnector;
import com.zee.servlets.backendconnector.DTOConvert;
import com.zee.servlets.web.viewmodels.UserVM;
import contract.dto.User;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private BackendConnectable connector;

    public LoginServlet() {
        connector = new BackendConnector();
    }

    public LoginServlet(BackendConnectable connector) {
        this.connector = connector;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            String page = "errorpage.jsp";
            String usernameInput = request.getParameter("user");
            String passwordInput = request.getParameter("pw");
            int agencyNumber = Integer.parseInt(request.getParameter("pw"));
            if (usernameInput != null && passwordInput != null) {

                UserVM userVM = connector.userLogin(usernameInput, passwordInput, agencyNumber);
                HttpSession session = request.getSession();
                session.setAttribute("currentSessionUser", DTOConvert.fromUserVm(userVM));
                page = "home.jsp";
                System.out.println("who logged in: " + session.getAttribute("currentSessionUser"));

//                for (int i = 0; i < users.size(); i++) {
//                    if (usernameInput.equals(users.get(i).getUserName()) && passwordInput.equals(users.get(i).getPassword())) {
//                        HttpSession session = request.getSession();
//                        session.setAttribute("currentSessionUser", users.get(i));
//                        System.out.println("who logged in: " + session.getAttribute("currentSessionUser"));
//                        page = "home.jsp";
//                        break;
//                    }else{
//                        continue;
//                    }
//                }
            }
                RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher(page);
                    requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
        }
    }
}
