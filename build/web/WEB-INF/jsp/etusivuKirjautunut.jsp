<%-- 
    Document   : etusivuKirjautunut
    Created on : 7.8.2015, 14:11:53
    Author     : Antero Oikkonen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Etusivu kirjautunut käyttäjä">
        <jsp:include page="header.jsp"></jsp:include>
        <div>
            <a href="TankkiServlet?new=true">Lisää uusi tankki</a>
        </div>
        <div>
            <a href="Valmistaja?lisaa=true">Lisää valmistaja</a>
        </div>
        <div>
            <a href="tankinvalmistaja.html">Tankin valmistaja</a>
        </div>
        <jsp:include page="etusivuYhteiset.jsp"></jsp:include>
</t:pohja>
