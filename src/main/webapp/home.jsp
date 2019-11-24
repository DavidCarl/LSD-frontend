<%@page import="com.sun.javafx.scene.layout.region.Margins"%>
<%@page import="contract.dto.*"%>
<!DOCTYPE html>
<html>

    <head>
        <title>LSD TRAVEL</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
        <link rel="stylesheet" href="./resources/stylescss.scss">
        <link rel="stylesheet" href="./resources/custom.css">

        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        </style>
    </head>

    <body class="w3-light-grey">
        <div class="w3-row">
            <div class="w3-col s2" ></div>
            <div class="w3-col s8">


                <div class="w3-margin-bottom m5">
                    <div class=" w3-col m1"></div>
                    <div class="mygif w3-col m10"></div>

                    <div class=" w3-col m1"></div>
                </div>

                <div class="w3-bar w3-white w3-large">
                    <a href="home.jsp" class="w3-bar-item w3-button w3-red w3-mobile"> Bookings</a>
                    <a href="searchFlight.jsp" class="w3-bar-item w3-button w3-mobile">Flight Offers</a>
                    <a href="schedule.jsp" class="w3-bar-item w3-button w3-mobile">Schedule</a>
                </div>

                <div>
                    <form action="PnrLookUpServlet" id="pnrservlet" method="get">
                        <div class="w3-margin-top m2">
                            <h3>Search for booking with PNR:</h3>
                            <input name="pnr" class="myinput w3-border" stlye="display: inline" type="number" placeholder="Type valid PNR"/>
                            <button class="w3-button w3-border  w3-border-black w3-black" type="Submit">Search</button>
                        </div>
                    </form>

                    <%
                        session = request.getSession();
                        Booking booking = booking = (Booking) session.getAttribute("booking");

                        if (booking == null) {
                            out.println("<div class='w3-margin-top m2'> <p>Please fill in a PNR that exists</p> </div>");
                        } else {
                            out.println("<div class='w3-margin-top m2'>");
                            out.println("<input id='pnrtag' type='hidden' value='"+ booking.getPnr().getPnr() +"'/>");
                            out.println("<p ><strong>PNR: </strong>" + booking.getPnr().getPnr() + "</p><p>&emsp;&emsp;&emsp; <strong> FFNCC: </strong> " + booking.getFfncc().getFfcc() + "</p>");

                            for (Ticket ticket : booking.getTickets()) {
                                out.println("<p><strong>Passengers: </strong> </p> <ul>");
                                out.println("<li>" + ticket.getPassenger().getFirstName() + " " + ticket.getPassenger().getLastName() + "</li>");
                                out.println("</ul>");
                            }
                            FlightRoute flightroute = booking.getFlightRoute();
                            for (Flight flight : flightroute.getFlights()) {
                                out.println("<p><strong>Flight: </strong></p> <ul>");
                                out.println("<li><strong>Airplane: </strong>" + flight.getAirplane().getIata() + "</li>");
                                out.println("<li><strong>Departure: </strong> " + flight.getDepAirport().getName() + ", " + flight.getDepDate() + "</li>");
                                out.println("<li><strong>Arrival: </strong>" + flight.getArrAirport().getName() + ", " + flight.getArrDate() + "</li>");

                                out.println("</ul>");
                            }
                            out.println("<p><strong>Price: </strong>" + booking.getPrice() + "</p>");
                            out.println("<form action='PnrLookUpServlet' id='pnrservlet' method='delete' ><button type='button' onClick='verify()' class='w3-button w3-border w3-red'><strong>Cancel booking</strong></button></form>");
                            out.println("</div>");
                        }
                    %>
                </div>
                <div class="w3-col-2"></div>

            </div>
        </div>
        <script>
            function verify() {
                var pnr = prompt("Please enter the PNR to cancel:", "");
                var pnrtag = document.getElementById("pnrtag").value;
                if (pnr === pnrtag) {
                    document.getElementById("pnrservlet").submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </body>

</html>