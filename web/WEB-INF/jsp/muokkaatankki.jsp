<%-- 
    Document   : muokkaatankki
    Created on : 12.8.2015, 16:18:59
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
                Tankin <c:out value="${otsikko}"/>
                <input type="hidden" name="toiminto" value="<c:out value="${otsikko2}"/>"></hidden>
                <input type="hidden" name="uid" value="<c:out value="${tankki.uid}"/>"></hidden>
            </div>
            <div>Nimi
                <input type="text" name="nimi" value="<c:out value="${tankki.nimi}"/>">

                Tyyppi

                <input type="text" name="tyyppi" value="<c:out value="${tankki.tyyppi}"/>">
                tykki

                <input type="text" name="tykki" value="<c:out value="${tankki.tykki}"/>">
            </div>
            <div>
                pituus
                <input type="text" name="pituus" value="<c:out value="${tankki.pituus}"/>">

                leveys
                <input type="text" name="leveys" value="<c:out value="${tankki.leveys}"/>">

                korkeus
                <input type="text" name="korkeus" value="<c:out value="${tankki.korkeus}"/>">
            </div>
            <div>
                Panssarointi<br>
                runko etu
                <input type="text" name="runkoetu" value="<c:out value="${tankki.runkoEtu}"/>">

                runko sivu
                <input type="text" name="runkosivu" value="<c:out value="${tankki.runkoSivu}"/>">

                runko taka
                <input type="text" name="runkotaka" value="<c:out value="${tankki.runkoTaka}"/>">

                <br>
                torni/ylärakenteet

                <br>
                etu
                <input type="text" name="tornietu" value="<c:out value="${tankki.torniEtu}"/>">

                sivu
                <input type="text" name="tornisivu" value="<c:out value="${tankki.torniSivu}"/>">

                taka
                <input type="text" name="tornitaka" value="<c:out value="${tankki.torniTaka}"/>">

            </div>

            <div>
                paino
                <input type="text" name="paino" value="<c:out value="${tankki.paino}"/>">

                moottori
                <input type="text" name="moottori" value="<c:out value="${tankki.moottori}"/>">

                teho
                <input type="text" name="teho" value="<c:out value="${tankki.teho}"/>">


                lisätietoa
                <input type="text" name="lisätieto" value="<c:out value="${tankki.lisatietoja}"/>">
            </div>
            <div>
                <input type="submit" value="Tallenna">
                <input type="submit" value="Peru">
                <a href="TankkiServlet?poista=true&uid=<c:out value="${tankki.uid}"/>">poista tankki</a>
            </div>
        </form>

    </body>
</html>
