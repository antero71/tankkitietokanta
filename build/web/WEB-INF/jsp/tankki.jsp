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
            panssarointi rungon edessä <c:out value="${tankki.runkoEtu}"/>
        </div>
        <div>
            panssarointi rungon sivuilla <c:out value="${tankki.runkoSivu}"/>
        </div>
        <div>
            panssarointi rungon takana <c:out value="${tankki.runkoTaka}"/>
        </div>
        <div>
            panssatointi tornin edessä <c:out value="${tankki.torniEtu}"/>
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
            lisätietoa <c:out value="${tankki.lisatietoja}"/>
        </div>
    </body>
</html>
