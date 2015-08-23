<%-- 
    Document   : tankki
    Created on : 7.8.2015, 21:54:16
    Author     : Antero Oikkonen
--%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Etusivu kirjautunut k�ytt�j�">
    <jsp:include page="header.jsp"></jsp:include>

        <h1>Tankki <c:out value="${tankki.nimi}"/></h1>
    <div>

        tyyppi <c:out value="${tankki.tyyppi}"/>

    </div>
    <div>
        tykki <c:out value="${tankki.tykki}"/>
    </div>
    <div>    

        pituus <c:out value="${tankki.pituus}"/>
    </div>
    <div>
        leveys <c:out value="${tankki.leveys}"/>
    </div>
    <div>
        korkeus <c:out value="${tankki.korkeus}"/>
    </div>
    <div>
        panssarointi rungon edess� <c:out value="${tankki.runkoEtu}"/>
    </div>
    <div>
        panssarointi rungon sivuilla <c:out value="${tankki.runkoSivu}"/>
    </div>
    <div>
        panssarointi rungon takana <c:out value="${tankki.runkoTaka}"/>
    </div>
    <div>
        panssatointi tornin edess� <c:out value="${tankki.torniEtu}"/>
    </div>
    <div>
        panssatointi tornin sivulla <c:out value="${tankki.torniSivu}"/>
    </div>
    <div>
        panssatointi tornin takana <c:out value="${tankki.torniTaka}"/>
    </div>
    <div>
        paino <c:out value="${tankki.paino}"/>
    </div>
    <div>
        moottori <c:out value="${tankki.moottori}"/>
    </div>
    <div>
        moottorin teho <c:out value="${tankki.teho}"/>
    </div>
    <div>
        lis�tietoa <c:out value="${tankki.lisatietoja}"/>
    </div>
</t:pohja>
