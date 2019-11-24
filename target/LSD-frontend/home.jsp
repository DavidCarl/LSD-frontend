<%@page import="contract.dto.*"%>
<!DOCTYPE html>
<html>
    <title>LSD TRAVEL</title>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Booking</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="stylescss.scss">
        <link rel="stylesheet" href="owncss.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        </style>
    </head>

    <body class="w3-light-grey">

        <div class="w3-margin-bottom m5">
            <div class=" w3-col m1"></div>
            <img class="w3-col m10" src="./image/sky.PNG" alt="My sky" style="width: 100%;">

            <div class=" w3-col m1"></div>
        </div>

        <div class="w3-bar w3-white w3-large">
            <a href="home.jsp" class="w3-bar-item w3-button w3-red w3-mobile"> Bookings</a>
            <a href="createbooking.jsp" class="w3-bar-item w3-button w3-mobile">Create booking</a>
            <a href="schedule.jsp" class="w3-bar-item w3-button w3-mobile">Schedule</a>
        </div>
        <form action="PnrLookUpServlet" id="pnrservlet" method="get">
            <div class="w3-margin-top m2">
                <h3>Search for booking with PNR:</h3>
                <input name="pnr" class="w3-input w3-border w3-col m4" type="text" placeholder="Type valid PNR"/>
                <button class="w3-button w3-border  w3-border-black w3-black" type="Submit">Search</button>
            </div>
        </form>
        
        <div>
            <% 
               session = request.getSession();
               Object pnr = session.getAttribute("pnr");
               System.out.println(pnr);
               if(pnr == null){
                   
               }else if (pnr != ""){
                   out.println("<p>"+pnr+"</p>");
               }else{
                  out.println("<p>du er en idiot</p>");
               }
              
               
            %>
        </div>
        
        <div>

        </div>
    </body>

</html>