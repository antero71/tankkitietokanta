<%-- 
    Document   : tankkilista
    Created on : 5.8.2015, 12:56:41
    Author     : Antero Oikkonen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tankkilista</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1>Tankkilista</h1>
        <c:forEach var="tankki" items="${tankit}">
            <div class="tankki"><a href="TankkiServlet?uid=${tankki.uid}"><c:out value="${tankki.nimi}"/></a><a href="TankkiServlet?uid=${tankki.uid}&muokkaa=true">Muokkaa</a></div>
        </c:forEach>
        <a href="TankkiServlet?new=true">Lisää uusi tankki</a>
    </body>
</html>
