<%@ page import="com.zee.servlets.web.viewmodels.OffersPageVM" %>
<%@ page import="com.zee.servlets.web.viewmodels.OfferVM" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: MoKayed
  Date: 10/28/2019
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<title>LSD TRAVEL</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
<body class="w3-light-grey">

<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-large">
    <a href="#" class="w3-bar-item w3-button w3-red w3-mobile"></i>LSD</a>
    <a href="#rooms" class="w3-bar-item w3-button w3-mobile">Flights</a>
    <a href="#about" class="w3-bar-item w3-button w3-mobile">About</a>
    <a href="#contact" class="w3-bar-item w3-button w3-mobile">Contact</a>
    <a href="#contact" class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Book Now</a>
</div>
<link rel="stylesheet" href="stylescss.scss">
<!-- Page content -->
<div class="w3-content" style="max-width:1532px;">
    <div class="w3-row-padding w3-padding-16">
        <h3>heelooo</h3>
    <% OffersPageVM viewModel = (OffersPageVM) request.getAttribute("viewModel");
//    out.print("<h6 class=\"w3-opacity\">" + viewModel + "</h6>");
    for (OfferVM offer : viewModel.getOffers()) {
        DateFormat dtf = new SimpleDateFormat("HH:MM");
        Date outLeaveDate = offer.getOutFlights().get(0).getDepDate();
        Date outArriveDate = offer.getOutFlights().get(offer.getOutFlights().size() - 1).getArrDate();
        out.print("<div class=\"w3-third w3-margin-bottom\">");
        out.print("<div class=\"w3-container w3-white\">");
        out.print("<h3 class=\"w3-opacity\">  <strong>" +
                dtf.format(outLeaveDate) + " - " + dtf.format(outArriveDate) + "</strong> " +
                offer.getOutFlights().get(0).getCarrierIata() + " </h3>");
        out.print("<h6 class=\"w3-opacity\"><strong>Direct</strong>  4t. 05m</h6>");
//        out.print("<h6>Is one way" + offer + "</h6>");
        if (!viewModel.isOneWay()) {
            Date returnLeaveDate = offer.getHomeFlights().get(0).getDepDate();
            Date returnArriveDate = offer.getHomeFlights().get(offer.getHomeFlights().size() - 1).getArrDate();
            out.print("<h3 class=\"w3-opacity\">   <strong>" +
                    dtf.format(returnLeaveDate) + " - " + dtf.format(returnArriveDate) + "</strong> " +
                    offer.getHomeFlights().get(0).getCarrierIata() + "</h3>");
            out.print("<h6 class=\"w3-opacity\"><strong>Direct</strong>  4t. 05m</h6>");
        }
        out.print("<p class=\"w3-large\"><h4 style=\"color: green\">" +
                offer.getPrice() + "$</h4></h4></p>");
        out.print("<button class=\"w3-button w3-block w3-black w3-margin-bottom\">Choose Flight <i class=\"fa fa-plane\"></i></button>");
        out.print("</div>");
        out.print("</div>");
    }
    %>



    </div>

    <!-- End page content -->
</div>
</div>


<!-- Add Google Maps -->

</body>

</html>
