<%-- 
    Document   : adminUsers
    Created on : Jan 1, 2019, 4:08:28 PM
    Author     : andrei
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
        <link rel="stylesheet" type="text/css" href="./css/ebookstore.css">
    </head>
<body>
        <%-- test if actual user is authenticated and authorized --%>
        
        <c:choose>
                <c:when test="${validUser == true}">   
                    <!-- include menu -->
                    <%@ include file="./navbar.jsp" %>
                    <%-- Master view --%>
                    <form action="${pageContext.request.contextPath}/AdminUsers" method="POST">
                        <sql:setDataSource 
                        var="snapshot" 
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/bookdb;create=true;"
                        user="test"  
                        password="password"/>
                        <sql:query dataSource="${snapshot}" var="result">
                            SELECT EBOOKS.USERS.SSN, EBOOKS.USERS.NAME, EBOOKS.USERS.PASSWORD, EBOOKS.USERS.ROLE FROM EBOOKS.USERS ORDER BY NAME, ROLE ASC 
                        </sql:query>
                        <div class="grid-container grid-container-users tablecenterdwithborder">
                            <div class="grid-item thc"> select </div>
                            <div class="grid-item thc"> SSN </div>  
                            <div class="grid-item thc">NAME</div>
                            <div class="grid-item thc">PASSWORD</div>
                            <div class="grid-item thc">ROLE</div>
                            <c:forEach var="row" varStatus="loop" items="${result.rows}">
                                <div class="grid-item tdc"><input type="checkbox" name="admin_users_checkbox" value="${row.ssn}"></div>
                                <div class="grid-item tdc"><c:out value="${row.ssn}"/></div>
                                <div class="grid-item tdc"><c:out value="${row.name}"/></div>
                                <div class="grid-item tdc"><c:out value="${row.password}"/></div>
                                <div class="grid-item tdc"><c:out value="${row.role}"/></div>
                            </c:forEach>
                        </div>
                        <%-- Details --%>
                        <sql:setDataSource 
                        var="snapshotroles"
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/bookdb;create=true;"
                        user="test"  
                        password="password"/>
                        <sql:query dataSource="${snapshotroles}" var="resultroles">
                            SELECT ROLE from EBOOKS.ROLES ORDER BY ROLE ASC
                        </sql:query>
                        <div>
                            <div class="grid-container grid-container-users-def tablecenteredwithborder">
                                <div class="grid-item"> SSN: </div>
                                <div class="grid-item"> <input type="text" name="admin_users_ssn" style="width: 150px"></input></div>
                                <div class="grid-item"> NAME: </div>
                                <div class="grid-item"> <input type="text" name="admin_users_username" style="width: 150px"></input></div>
                                <div class="grid-item"> PASSWORD: </div>
                                <div class="grid-item"> <input type="password" name="admin_users_password"></input></div>
                                <div class="grid-item"> ROLE: </div>
                                <div class="grid-item">
                                    <select name="admin_user_role" required="true">
                                        <c:forEach var="rowrole" items="${resultroles.rows}">    
                                            <option name="admin_users_roles" value="${rowrole.role}">${rowrole.role}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <%-- buttons --%>
                            <div>
                                <input type="submit" class="ebooksstorebutton" name="admin_users_insert" value="Insert"> 
                                <input type="submit" class="ebooksstorebutton" name="admin_users_update" value="Update">
                                <input type="submit" class="ebooksstorebutton" name="admin_users_delete" value="Delete"> 
                                <input type="submit" class="ebooksstorebutton" name="admin_users_cancel" value="Cancel">
                            </div>
                        </div>    
                    </form>
            </c:when>
            <c:otherwise>
                <c:redirect url="./index.jsp"></c:redirect>
            </c:otherwise>
        </c:choose>
</body>    
</html>
