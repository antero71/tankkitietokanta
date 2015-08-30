<%-- 
    Document   : tankkilista
    Created on : 5.8.2015, 12:56:41
    Author     : Antero Oikkonen
--%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pohja pageTitle="Tankkilista">

    <h1>Tankkilista</h1>
    <c:forEach var="tankki" items="${tankit}">
        <div class="tankki"><a href="TankkiServlet?uid=${tankki.uid}&nayta=true"><c:out value="${tankki.nimi}"/></a> <a href="TankkiServlet?uid=${tankki.uid}&muokkaa=true">Muokkaa</a></div>
    </c:forEach>
</t:pohja>
