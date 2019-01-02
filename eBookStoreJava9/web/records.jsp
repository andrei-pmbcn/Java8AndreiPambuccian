<%-- 
    Document   : recordsPage
    Created on : Jan 1, 2019, 3:58:51 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records</title>
        <link rel="stylesheet" type="text/css" href="./css/ebookstore.css">
    </head>
    <body>
        <c:choose>
            <c:when test="${validUser == true}">
                <%@ include file="./navbar.jsp" %>
                <sql:setDataSource 
                        var="snapshot" 
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/bookdb;create=true;"
                        user="test"  
                        password="password"/>
                <sql:query dataSource="${snapshot}" var="result">
                        SELECT EBOOKS.EBOOKS.DENUMIRE, EBOOKS.EBOOKS.ISBN, EBOOKS.EBOOKS.PRET,
                            EBOOKS.BOOK_TYPES.TYPE, EBOOKS.BOOK_GENRES.GENRE
                            FROM EBOOKS.EBOOKS, EBOOKS.BOOK_TYPES, EBOOKS.BOOK_GENRES
                            WHERE EBOOKS.EBOOKS.ID_TYPE = EBOOKS.BOOK_TYPES.ID
                                AND EBOOKS.EBOOKS.ID_GENRE = EBOOKS.BOOK_GENRES.ID
                            ORDER BY DENUMIRE ASC
                </sql:query>
                <div class="grid-container grid-container-books tablecenterdwithborder">
                    <div class="grid-item thc">DENUMIRE</div>
                    <div class="grid-item thc">ISBN</div>  
                    <div class="grid-item thc">PRET</div>
                    <div class="grid-item thc">TIP</div>
                    <div class="grid-item thc">SUBIECT</div>
                    <c:forEach var="row" varStatus="loop" items="${result.rows}">
                        <div class="grid-item tdc"><c:out value="${row.denumire}"/></div>
                        <div class="grid-item tdc"><c:out value="${row.isbn}"/></div>
                        <div class="grid-item tdc"><c:out value="${row.pret}"/></div>
                        <div class="grid-item tdc"><c:out value="${row.type}"/></div>
                        <div class="grid-item tdc"><c:out value="${row.genre}"/></div>
                    </c:forEach>
                </div>   
                    
                
                
            </c:when>
            <c:otherwise>
                <c:redirect url="./index.jsp"></c:redirect>
            </c:otherwise>
        </c:choose>
    </body>
</html>
