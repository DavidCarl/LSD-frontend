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
<form  name="getDeals" action="CreateBookingServlet" method="post">

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
        <span></span>
        <script>
            console.log("bobstart");
            var viewModel;
        </script>
<%--        <input type="hidden" id="viewModel"/>--%>
        <% OffersPageVM viewModel = (OffersPageVM) request.getAttribute("viewModel");
            HttpSession session = request.getSession();
            session.setAttribute("offerPrice", offer.getPrice());
//            out.print("<input type=\"h(viewModel)+ "\"/>");
            out.print("<span id='jsonViewModel' style='display:none;'>" + new Gson().toJson(viewModel) + "</span>");
//            out.print("<h6 class=\"w3-opacity\">" + viewModel + "</h6>");
            for (OfferVM offer : viewModel.getOffers()) {
                DateFormat dtf = new SimpleDateFormat("HH:MM");
                FlightVM firstFlightOut = offer.getOutFlights().get(0);
                FlightVM lastFlightOut = offer.getOutFlights().get(offer.getOutFlights().size() - 1);
                Date outLeaveDate = firstFlightOut.getDepDate();
                Date outArriveDate = lastFlightOut.getArrDate();
                out.print("<div class=\"w3-third w3-margin-bottom offer-box\">");
                out.print("<span class=\"offer-data\" style='display:none;'>" + new Gson().toJson(offer) + "</span>");
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
                //out.print("<button class=\"w3-button w3-block w3-black w3-margin-bottom\">Choose Flight <i class=\"fa fa-plane\"></i></button>");
                out.print(" <button type=\"button\" class=\"w3-button w3-block w3-black w3-margin-bottom deal-btn\" data-toggle=\"modal\" data-target=\"#myModal\">Choose Flight <i class=\"fa fa-plane\"></i></button>");
                out.print("</div>");
                out.print("</div>");
                out.print("<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">");
                out.print("<div class=\"modal-dialog\">");
                out.print("<div class=\"modal-content\">");
                out.print("<div class=\"modal-header\">");
                out.print("<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>");
                out.print("<h4 class=\"modal-title\">Modal Header</h4>");
                out.print("</div>");
                out.print("<div class=\"modal-body\">");
                out.print("<h3>Out Flights</h3>");
                out.print("<div id='travelFlights'></div>");
//                out.print("<p>" +   dtf.format(outLeaveDate) + " - " +  offer.getOutFlights().get(0).getCarrierIata()+
//                        "</p>");
                out.print("<h3 id='returnFlightsListTitle'>Return flights</h3>");
                out.print("<div id='returnFlights'></div>");
                out.print("<label><i class=\"fa fa-male\"></i> Adults</label>");
                out.print("<input name=\"adults\" class=\"w3-input w3-border\" min=\"0\" type=\"number\" value=\"0\" id=\"adults\">");
                out.print("<div id='formDiv'></div>");
                out.print("<input class=\"w3-input w3-border w3-col m4\" type=\"text\" placeholder=\"FFN or creadit card no.\">");
                out.print("</div>");
                out.print("<div class=\"modal-footer\">");
                out.print("<button type=\"button\" class=\"btn btn-default btn-danger float-left\" data-dismiss=\"modal\">Close</button>");
                out.print("<button type=\"submit\" class=\"btn btn-default btn-success\" >Create booking</button>");
                out.print("</div>");
                out.print("</div>");
                out.print("</div>");
                out.print("</div>");



            }
        %>
        <script>
            console.log("withsiodfknskdf");
            $(function () {
                viewModel = JSON.parse($("#jsonViewModel").text());



                $(".deal-btn").click(function () {
                    var $btn = $(this);
                    var offerData = JSON.parse($btn.closest(".offer-box").find(".offer-data").text());
                    console.log(offerData);
                    $("#travelFlights").empty();
                    offerData.outFlights.forEach(function (flight, index) {
                        function formatDate(date) {
                            var dd = date.getDate();
                            var mm = date.getMonth() + 1; //January is 0!

                            var yyyy = date.getFullYear();
                            if (dd < 10) {
                                dd = '0' + dd;
                            }
                            if (mm < 10) {
                                mm = '0' + mm;
                            }
                            return dd + '/' + mm + '/' + yyyy;
                        }
                        $("#travelFlights").append("<i class=\"fa fa-plane\"></i>");
                        $("#travelFlights").append("<p>"+ flight.depDate +" - "  + flight.arrDate + "</p>");
                        $("#travelFlights").append("<p>"+
                            flight.arrAirport.name + " (" + flight.arrAirport.iata + ")" +
                            " - "  +
                            flight.depAirport.name + " (" + flight.depAirport.iata + ")" + "</p>");


                    });
                    if (viewModel.oneWay) {
                        $("#returnFlightsListTitle").hide();
                    } else {
                        $("#returnFlightsListTitle").show();
                        $("#returnFlights").empty();
                        offerData.homeFlights.forEach(function (flight, index) {
                            function formatDate(date) {
                                var dd = date.getDate();
                                var mm = date.getMonth() + 1; //January is 0!

                                var yyyy = date.getFullYear();
                                if (dd < 10) {
                                    dd = '0' + dd;
                                }
                                if (mm < 10) {
                                    mm = '0' + mm;
                                }
                                return dd + '/' + mm + '/' + yyyy;
                            }
                            $("#returnFlights").append("<i class=\"fa fa-plane\"></i>");
                            $("#returnFlights").append("<p>"+ flight.depDate +" - "  + flight.arrDate + "</p>");
                            $("#returnFlights").append("<p>"+
                                flight.arrAirport.name + " (" + flight.arrAirport.iata + ")" +
                                " - "  +
                                flight.depAirport.name + " (" + flight.depAirport.iata + ")" + "</p>");


                        });
                    }
                });

            });
        </script>
        <div id="passengerInfoTemplate" style="display:none;">
            <div name="passengerid">
                <input class="w3-input w3-border w3-col m4 p-firstname" type="text" placeholder="Firstname">
                <input class="w3-input w3-border w3-col m4 p-lastname" type="text" placeholder="Lastname">
                <input class="w3-input w3-border w3-col m4 p-dob" type="text" placeholder="Month/Day/Year">
            </div>
        </div>
        <script>
            $(function () {
                $("#adults").click(function () {
                    createForms();
                });
            });
            function createForms() {
                console.log("create forms");
                var adults = parseInt($("#adults").val())
                var $formDiv = $("#formDiv");
                $formDiv.empty();
                console.log(adults);
                for (var i = 0; i < adults; i++) {
                    console.log("p" + i);
                    var $pInforHtml = $("#passengerInfoTemplate").clone();
                    $pInforHtml.removeAttr("id");
                    $pInforHtml.removeAttr("style");
                    $pInforHtml.find(".p-firstname").attr("name", "firstname" + i);
                    $pInforHtml.find(".p-lastname").attr("name", "lastname" + i);
                    $pInforHtml.find(".p-dob").attr("name", "dob" + i);
                    $formDiv.append($pInforHtml);
                    console.log("appended")
                }

                // formDiv.innerHTML = "";
                // for (var i = 0; i < totalPassengers; i++) {
                //     var passengerid = "pid" + i;
                //     var firstnameid = "firstname" + i;
                //     var lastnameid = "lastname" + i;
                //     var dobid = "dob" + i
                //     console.log(passengerid, firstnameid, lastnameid, dobid)
                //
                //     formDiv.innerHTML += `<div name=passengerid>
                //                             <input name="firstnameid" class="w3-input w3-border w3-col m4" type="text" placeholder="Firstname">
                //                             <input name="lastnameid" class="w3-input w3-border w3-col m4" type="text" placeholder="Lastname">
                //                             <input name="dobid" class="w3-input w3-border w3-col m4" type="text" placeholder="Month/Day/Year">
                //                           </div>`
                //     document.getElementsByName("firstnameid")[0].setAttribute("name", firstnameid);
                //     document.getElementsByName("lastnameid")[0].setAttribute("name", lastnameid);
                //     document.getElementsByName("dobid")[0].setAttribute("name", dobid);
                // }
                // formDiv.innerHTML += `
                //                         <input name="ffncc" class="w3-input w3-border w3-col m4" type="text" placeholder="Creditcard or FFNR">
                //                          <input name="price" class="w3-input w3-border w3-col m4" type="number" placeholder="Payment">
                //                          <button type="submit" form="bookingid"  class="w3-button w3-block w3-black"> Create booking </button>`

            }
        </script>
    </div>
    <!-- End page content -->
</div>
</form>
</div>


<!-- Add Google Maps -->

</body>

</html>