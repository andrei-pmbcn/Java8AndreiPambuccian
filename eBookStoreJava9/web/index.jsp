<%-- 
    Document   : Index.jsp
    Created on : Dec 28, 2018, 5:00:34 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="stylesheet" type="text/css" href="./css/ebookstore.css">
    </head>
    <body>
        <%--
        <h1>Hello World!</h1>
        <%! int i = 2; %>
        <div> Testing variable <%= i %> </div>
        --%>
        
        <c:set var="activePage" value="index" scope="session"></c:set>
        <h3>Welcome to the electronic bookstore</h3>
        <%-- <hr> --%>
        <!-- delegation of authentication and authorization is done in the associated Servlet -->
        <div class="tablecenteredwithborder">
            <form action="${pageContext.request.contextPath}/Index" method="POST">
                <div class="grid-container">
                    <div class="grid-item">Username: </div>
                    <input class = "inputlarge" type="text" name="authenticationpage_username"></input>
                    <div class="grid-item">Password: </div>
                    <input class = "inputlarge" type="password" name="authenticationpage_password"></input>
                </div>
                <input type="submit" name="authenticationpage_authenticate" value="Login"></input></td></tr>
            </form>
        </div>
    </body>
</html>
