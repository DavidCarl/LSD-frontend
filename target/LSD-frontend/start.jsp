<%--
  Created by IntelliJ IDEA.
  User: MoKayed
  Date: 10/28/2019
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<center>
    <h1 name="user">Hello <%= session.getAttribute("currentSessionUser") %></h1>
</center>
</body>
</html>
