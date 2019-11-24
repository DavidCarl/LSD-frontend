<!DOCTYPE html>
<html>
<title>LSD TRAVEL</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.0/css/font-awesome.min.css">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
<body class="w3-light-grey">

<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-large">
    <a href="#" class="w3-bar-item w3-button w3-red w3-mobile"><i class="fas fa-plane"></i>LSD</a>
    <a href="#rooms" class="w3-bar-item w3-button w3-mobile">Flights</a>
    <a href="#about" class="w3-bar-item w3-button w3-mobile">About</a>
    <a href="#contact" class="w3-bar-item w3-button w3-mobile">Contact</a>
    <a href="#contact" class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Book Now</a>
</div>
<link rel="stylesheet" href="stylescss.scss">
<!-- Page content -->
<div class="w3-container w3-margin-top" id="rooms">
    <h3>LSD-TRAVEL</h3>
    <p>Welcome to LSD-Travel, e offer the best travel deals in the industry.</p>
</div>
<form name="getOffer" method="post" action="OfferServlet" >
    <input id="oneWayChecker" type="checkbox" name="oneWayBox"> One way<br>
    <input id="oneWayVal" type="hidden" name="oneWay" value="false">
    <script>
        $(function () {
            console.log("init jq");
            $("#oneWayChecker").click(function () {
                var $box = $(this);
                console.log("cicked");
                if ($box.prop("checked", true)) {
                    console.log("checked");
                    $("#oneWayVal").val("true");
                } else {
                    console.log("unchecked");
                    $("#oneWayVal").val("false");

                }
            })
        })
    </script>
    <div class="w3-content" style="max-width:1532px;">
        <div class="w3-col m2">
            <div class="form-group">
                <label class="fa fa-calendar-o">From: </label>
                <input name ="fromAirport" id="fromAirport" class="w3-input w3-border" type="text" placeholder="From airport" />
            </div>
        </div>

        <div class="w3-col m2">
            <div class="form-group">
                <label class="fa fa-calendar-o">To: </label>
                <input name="toAirport" id="toAirport" class="w3-input w3-border" type="text" placeholder="To airport" />
            </div>
        </div>
        <div class="w3-col m2">
            <label><i class="fa fa-calendar-o"></i>Depart Date:</label>
            <input class="w3-input w3-border date-picker-lsd" type="text" name="depDate" id="depDate" placeholder="DD MM YYYY">
        </div>
        <div id="depDateContainer" class="w3-col m2">
            <label><i class="fa fa-calendar-o"></i>Return Date:</label>
            <input class="w3-input w3-border date-picker-lsd" type="text" name="retDate" id="retDate" placeholder="DD MM YYYY">
        </div>
        <div class="w3-col m2">
            <label><i class="fa fa-male"></i> Adults</label>
            <input class="w3-input w3-border" type="number" name="adultNumber" id="adultNumber" placeholder="1">
        </div>

        <div class="w3-col m2"> <label style="opacity:0">empty</label>
            <button class="w3-button w3-block w3-black" type="submit">Search</button>
        </div>
    </div>
</form>
<div class="w3-row-padding w3-padding-16">
    <div class="w3-third w3-margin-bottom">
        <img src="https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fspecials-images.forbesimg.com%2Fdam%2Fimageserve%2F755060713%2F960x0.jpg%3Ffit%3Dscale" alt="Norway" style="width:100%">
        <div class="w3-container w3-white">
            <h3>Fly to Norway</h3>
            <h6 class="w3-opacity">From $99</h6>
            <p>Direct flight</p>
            <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i></p>
            <button class="w3-button w3-block w3-black w3-margin-bottom">Choose Flight</button>
        </div>
    </div>
    <div class="w3-third w3-margin-bottom">
        <img src="https://static.toiimg.com/photo/55832119/.jpg" alt="Copenhagen" style="width:100%">
        <div class="w3-container w3-white">
            <h3>Fly to Copenhagen</h3>
            <h6 class="w3-opacity">From $149</h6>
            <p>Direct flight</p>
            <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i></p>
            <button class="w3-button w3-block w3-black w3-margin-bottom">Choose Flight</button>
        </div>
    </div>

    <div class="w3-third w3-margin-bottom">
        <img src="https://media.cntraveler.com/photos/5cf96a9dd9fb41f17ed08435/master/pass/Eiffel%20Tower_GettyImages-1005348968.jpg" alt="Paris" style="width:100%">
        <div class="w3-container w3-white">
            <h3>Fly to Paris</h3>
            <h6 class="w3-opacity">From $199</h6>
            <p>Direct</p>
            <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i> <i class="fa fa-glass"></i> <i class="fa fa-cutlery"></i></p>
            <button class="w3-button w3-block w3-black w3-margin-bottom">Choose Flight</button>
        </div>
    </div>
</div>
<!-- End page content -->
</div>

<!-- Footer -->
<footer class="w3-padding-32 w3-black w3-center w3-margin-top">
    <h5>Made by:</h5>

    <p>Group 5</p>
</footer>

<!-- Add Google Maps -->
<script>
    function myMap() {
        myCenter=new google.maps.LatLng(41.878114, -87.629798);
        var mapOptions= {
            center:myCenter,
            zoom:12, scrollwheel: false, draggable: false,
            mapTypeId:google.maps.MapTypeId.ROADMAP
        };
        var map=new google.maps.Map(document.getElementById("googleMap"),mapOptions);

        var marker = new google.maps.Marker({
            position: myCenter,
        });
        marker.setMap(map);
    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>
<script src="https://cdn.jsdelivr.net/npm/airport-autocomplete-js@latest/dist/index.browser.min.js"></script>
<script>
    AirportInput("fromAirport");
    AirportInput("toAirport");
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


<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->

</body>

</html>
