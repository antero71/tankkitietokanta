<%-- 
    Document   : etusivuKirjautunut
    Created on : 7.8.2015, 14:11:53
    Author     : Antero Oikkonen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Etusivu kirjautunut käyttäjä">
    <div>
        <a href="TankkiServlet?new=true">Lisää uusi tankki</a>
    </div>
    <div>
        <a href="LisaaValmistaja">Lisää valmistaja</a>
    </div>
    <jsp:include page="etusivuYhteiset.jsp"></jsp:include>
</t:pohja>
