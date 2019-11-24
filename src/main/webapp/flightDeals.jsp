<%@ page import="com.zee.servlets.web.viewmodels.OffersPageVM" %>
<%@ page import="com.zee.servlets.web.viewmodels.OfferVM" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.zee.servlets.web.viewmodels.FlightVM" %>
<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: MoKayed
  Date: 10/28/2019
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<!DOCTYPE html>
<title>LSD TRAVEL</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
    <div class="w3-row-padding w3-padding-16">
        <h3>heelooo</h3>
        <input type="hidden" id="viewModel"/>
    <% OffersPageVM viewModel = (OffersPageVM) request.getAttribute("viewModel");
    out.print("<input type=\"hidden\" id=\"viewModel\" value=\"" +
                    new Gson().toJson(viewModel)+ "\"/>");
    out.print("<h6 class=\"w3-opacity\">" + viewModel + "</h6>");
    for (OfferVM offer : viewModel.getOffers()) {
        DateFormat dtf = new SimpleDateFormat("HH:MM");
        FlightVM firstFlightOut = offer.getOutFlights().get(0);
        FlightVM lastFlightOut = offer.getOutFlights().get(offer.getOutFlights().size() - 1);
        Date outLeaveDate = firstFlightOut.getDepDate();
        Date outArriveDate = lastFlightOut.getArrDate();
        out.print("<div class=\"w3-third w3-margin-bottom\">");
        out.print("<div class=\"w3-container w3-white\">");
        out.print("<h3 class=\"w3-opacity\">  <strong>" +
                dtf.format(outLeaveDate) + " - " + dtf.format(outArriveDate) + "</strong> " +
                offer.getOutFlights().get(0).getCarrierIata() + " </h3>");
        int noOfFlightsOut = offer.getOutFlights().size();
        String directMsgOut = "Direct flight";
        if (noOfFlightsOut > 1) directMsgOut = noOfFlightsOut + " flights";
        out.print("<h6 class=\"w3-opacity\"><strong>" +
                        directMsgOut + "</strong> </h6>");
//        out.print("<h6>Is one way" + offer + "</h6>");
        if (!viewModel.isOneWay()) {
            Date returnLeaveDate = offer.getHomeFlights().get(0).getDepDate();
            Date returnArriveDate = offer.getHomeFlights().get(offer.getHomeFlights().size() - 1).getArrDate();
            out.print("<h3 class=\"w3-opacity\">   <strong>" +
                    dtf.format(returnLeaveDate) + " - " + dtf.format(returnArriveDate) + "</strong> " +
                    offer.getHomeFlights().get(0).getCarrierIata() + "</h3>");
            int noOfFlightsHome = offer.getHomeFlights().size();
            String directMsgHome = "Direct flight";
            if (noOfFlightsHome > 1) directMsgHome = noOfFlightsHome + " flights";
            out.print("<h6 class=\"w3-opacity\"><strong>" +
                    directMsgHome + "</strong> </h6>");
        }
        out.print("<p class=\"w3-large\"><h4 style=\"color: green\">" +
                offer.getPrice() + "$</h4></h4></p>");
        out.print("<button class=\"w3-button w3-block w3-black w3-margin-bottom\">Choose Flight <i class=\"fa fa-plane\"></i></button>");
        out.print("</div>");
        out.print("</div>");
    }
    %>
    </div>
    <!-- Modal -->
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                    <p>Some text in the modal.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

    <!-- End page content -->
</div>
</div>


<!-- Add Google Maps -->

</body>

</html>
