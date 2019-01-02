<%-- 
    Document   : navbar
    Created on : Jan 1, 2019, 4:12:08 PM
    Author     : andrei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="./css/menu.css">

<ul id="nav">
   <c:if test="${actualUserRole == 'admin'}">
        <li><a href="records.jsp">List books</a></li>
        <li><a href="adminUsers.jsp">Manage users</a></li>
        <!--<li><a href="adminRoles.jsp">Manage roles</a></li>-->
        <!--<li><a href="adminBooks.jsp">Manage books</a></li>-->
    </c:if>
    <li><a href="./exit.jsp">Log out</a></li>
</ul>