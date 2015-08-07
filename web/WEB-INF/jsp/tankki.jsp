<%-- 
    Document   : tankki
    Created on : 7.8.2015, 21:54:16
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
        <h1>Tankki <c:out value="${tankki.nimi}"/></h1>
        <div>
            
            <c:out value="${tankki.tyyppi}"/>
            <c:out value="${tankki.tykki}"/>
            <c:out value="${tankki.pituus}"/>
            <c:out value="${tankki.leveys}"/>
            <c:out value="${tankki.korkeus}"/>
            <c:out value="${tankki.runkoEtu}"/>
            <c:out value="${tankki.runkoSivu}"/>
            <c:out value="${tankki.runkoTaka}"/>
            <c:out value="${tankki.torniEtu}"/>
            <c:out value="${tankki.torniSivu}"/>
            <c:out value="${tankki.torniTaka}"/>
            <c:out value="${tankki.paino}"/>
            <c:out value="${tankki.moottori}"/>
            <c:out value="${tankki.teho}"/>
            <c:out value="${tankki.lisatietoja}"/>
        </div>
    </body>
</html>
