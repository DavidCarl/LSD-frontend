<%-- 
    Document   : singlebooking
    Created on : Nov 22, 2019, 8:46:35 PM
    Author     : Mikkel
--%>

<%@page import="contract.dto.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <% 
            Booking book = (Booking) session.getAttribute("booking");
            out.println("<p>"+book.getPnr().getPnr()+"</p>");
            out.println("<p>"+book.getFfncc().getFfcc()+"</p>");
            out.println("<p>"+book.getTickets().size()+"</p>");
            
        %>
    </body>
</html>
