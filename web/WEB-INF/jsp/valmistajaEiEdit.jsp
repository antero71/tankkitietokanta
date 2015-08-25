<%-- 
    Document   : valmistajaEiEdit
    Created on : 25.8.2015, 9:44:48
    Author     : Antero Oikkonen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<t:pohja pageTitle="Valmistajan tiedot">
    <h1>Valmistaja <c:out value="${valmistaja.nimi}"/></h1>
    <div>

        paikkakunta <c:out value="${valmistaja.paikkakunta}"/>

    </div>
</t:pohja>

