<%-- 
    Document   : valmistajat
    Created on : 16.8.2015, 13:00:04
    Author     : Antero Oikkonen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <h1>Valmistajalista</h1>
        <c:forEach var="valmistaja" items="${valmistajat}">
            <div class="tankki"><a href="Valmistaja?uid=${valmistaja.uid}"><c:out value="${valmistaja.nimi}"/></a> <a href="MuokkaaValmistajaa?uid=${valmistaja.uid}">Muokkaa</a></div>
        </c:forEach>
    </body>
</html>
