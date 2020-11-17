<%-- 
    Document   : forgot
    Created on : Nov 17, 2020, 11:21:27 AM
    Author     : 831690
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <p>${message}</p>
        <form action="forgot" method="post">
            Email Address: <input type="text" name="email"> <br>
            <input type="Submit" value="Submit">
        </form>
    </body>
</html>
