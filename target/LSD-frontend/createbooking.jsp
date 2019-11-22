<%-- 
    Document   : createbooking.jsp
    Created on : 21-11-2019, 15:36:12
    Author     : Mathias BJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Booking</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="stylescss.scss">
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        </style>
    </head>
    <body class="w3-light-grey">

        <!-- Navigation Bar -->
        <div class="w3-bar w3-white w3-large">
            <a href="home.jsp" class="w3-bar-item w3-button w3-mobile"> Bookings</a>
            <a href="createbooking.jsp" class="w3-bar-item w3-button w3-red w3-mobile">Create booking</a>
            <a href="schedule.jsp" class="w3-bar-item w3-button w3-mobile">Schedule</a>
        </div>
        <link rel="stylesheet" href="stylescss.scss">
        <!-- Page content -->
        <div class="w3-content" style="max-width:1532px;">

            <div class="w3-container w3-margin-top" id="rooms">
                <h3>LSD-TRAVEL</h3>
                <p>Welcome to LSD-Travel, we offer the best travel deals in the industry.</p>
            </div>
            <input id="oneWayChecker" type="checkbox" name="vehicle1" value="Bike"> One way<br>
            <script>
                $(function () {
                    console.log("init jq");
                    $("#oneWayChecker").click(function () {
                        var $box = $(this);
                        console.log("cicked");
                        if ($box.prop("checked", true)) {
                            console.log("checked");
                        } else {
                            console.log("unchecked");
                        }
                    })
                })
            </script>
            <form action="BookingServlet" id="bookingid" method="post">
                <div class="w3-col m2">
                    <div class="form-group">
                        <label class="fa fa-calendar-o">From: </label>
                        <input name="autocompletefrom" class="w3-input w3-border" type="text" placeholder="From airport" />
                    </div>
                </div>

                <div class="w3-col m2">
                    <div class="form-group">
                        <label class="fa fa-calendar-o">To: </label>
                        <input name="autocompleteto" class="w3-input w3-border" type="text" placeholder="To airport" />
                    </div>
                </div>
                <div class="w3-col m2">
                    <label><i class="fa fa-calendar-o"></i>Depart Date:</label>
                    <input name="departDate" class="w3-input w3-border date-picker-lsd" type="text" placeholder="DD MM YYYY">
                </div>
                <div id="depDateContainer" class="w3-col m2">
                    <label><i class="fa fa-calendar-o"></i>Return Date:</label>
                    <input name="returnDate" class="w3-input w3-border date-picker-lsd" type="text" placeholder="DD MM YYYY">
                </div>
                <div class="w3-col m1">
                    <label><i class="fa fa-male"></i> Adults</label>
                    <input name="adults" class="w3-input w3-border" type="number" value="0" id="adults">
                </div>
                <div class="w3-col m1">
                    <label><i class="fa fa-male"></i> Children</label>
                    <input name="children" class="w3-input w3-border" type="number" value="0" id="children">
                </div>
                <div class="w3-col m2"> <label style="opacity:0">empty</label>
                    <button type="button" class="w3-button w3-block w3-black" onClick="createForms()"> Accept criteria</button>
                </div> 


                <div id="formDiv" class="w3-col m12">

                </div>
            </form>

            <!-- End page content -->
        </div>
        <script>
            function createForms() {
                var adults = parseInt(document.getElementById("adults").value)
                var children = parseInt(document.getElementById("children").value)
                var totalPassengers = adults + children
                var formDiv = document.getElementById("formDiv");
                formDiv.innerHTML = "";
                for (var i = 0; i < totalPassengers; i++) {
                    var passengerid = "pid" + i;
                    var firstnameid = "firstname" + i;
                    var lastnameid = "lastname" + i;
                    var dobid = "dob" + i
                    console.log(passengerid, firstnameid, lastnameid, dobid)

                    formDiv.innerHTML += `<div name=passengerid>
                                            <input name="firstnameid" class="w3-input w3-border w3-col m4" type="text" placeholder="Firstname">
                                            <input name="lastnameid" class="w3-input w3-border w3-col m4" type="text" placeholder="Lastname">
                                            <input name="dobid" class="w3-input w3-border w3-col m4" type="text" placeholder="Month/Day/Year">
                                          </div>`
                    document.getElementsByName("firstnameid")[0].setAttribute("name", firstnameid);
                    document.getElementsByName("lastnameid")[0].setAttribute("name", lastnameid);
                    document.getElementsByName("dobid")[0].setAttribute("name", dobid);
                }
                formDiv.innerHTML += `
                                        <input name="ffncc" class="w3-input w3-border w3-col m4" type="text" placeholder="Creditcard or FFNR">
                                         <input name="price" class="w3-input w3-border w3-col m4" type="number" placeholder="Payment">
                                         <button type="submit" form="bookingid"  class="w3-button w3-block w3-black"> Create booking </button>`

            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/airport-autocomplete-js@latest/dist/index.browser.min.js"></script>
        <script>
            AirportInput("autocompletefrom");
            AirportInput("autocompleteto");
        </script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $(".date-picker-lsd").datepicker();
                $("#oneWayChecker").click(function () {
                    var $box = $(this);
                    if ($box.prop("checked")) {
                        $("#depDateContainer").hide();
                    } else {
                        $("#depDateContainer").show();
                    }
                })
            })
        </script>
    </body>
</html>
