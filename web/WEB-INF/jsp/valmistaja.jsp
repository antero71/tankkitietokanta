<%-- 
    Document   : valmistaja
    Created on : 16.8.2015, 12:24:47
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
        <form>
            <div>
                valmistaja
                <input type="text" name="nimi" value="${valmistaja.nimi}">

                paikkakunta
                <input type="text" name="paikkakunta" value="${valmistaja.paikkakunta}">
            </div>
            <div>
                <input type="submit" value="Tallenna">
                <input type="submit" value="Peru">
                <a href="PoistaValmistaja&uid=<c:out value="${valmistaja.uid}"/>">poista valmistaja</a>
            </div>
        </form>
        <jsp:include page="virheet.jsp"></jsp:include>
    </body>
</html>
