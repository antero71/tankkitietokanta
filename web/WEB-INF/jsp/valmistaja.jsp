<%-- 
    Document   : valmistaja
    Created on : 16.8.2015, 12:24:47
    Author     : Antero Oikkonen
--%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Tankin tiedot">
    <form>
        <input type="hidden" name="uid" value="<c:out value="${valmistaja.uid}"/>"></hidden>
        <div>
            valmistaja
            <input type="text" name="nimi" value="${valmistaja.nimi}">

            paikkakunta
            <input type="text" name="paikkakunta" value="${valmistaja.paikkakunta}">
        </div>
        <div>
            <input type="submit" value="Tallenna">
            <input type="submit" value="Peru">
            <a href="PoistaValmistaja?uid="<c:out value="${valmistaja.uid}"/>">poista valmistaja</a>
        </div>
    </form>
</t:pohja>
