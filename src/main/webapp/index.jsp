<!DOCTYPE html>
<html>
<head>
    <title>Loginpage</title>
    <meta charset="UTF-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="./resources/login.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <div class="fadeIn first">
        </div>
        <!-- Login Form -->
        <form action="LoginServlet" method="post">
            <h2>Please enter your login details</h2>
            <input type="text" id="login" class="fadeIn second" name="user" placeholder="Username">
            <input type="password" id="password" class="fadeIn third" name="pw" placeholder="********">
            <input type="submit" class="fadeIn fourth" value="login">
        </form>
    </div>
</div>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>