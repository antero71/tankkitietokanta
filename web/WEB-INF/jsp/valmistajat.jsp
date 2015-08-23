<%-- 
    Document   : valmistajat
    Created on : 16.8.2015, 13:00:04
    Author     : Antero Oikkonen
--%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pohja pageTitle="Tankin tiedot">
    <h1>Valmistajalista</h1>
    <c:forEach var="valmistaja" items="${valmistajat}">
        <div class="tankki"><a href="Valmistaja?uid=${valmistaja.uid}"><c:out value="${valmistaja.nimi}"/></a> <a href="MuokkaaValmistajaa?uid=${valmistaja.uid}">Muokkaa</a></div>
    </c:forEach>
</body>
</t:pohja>
