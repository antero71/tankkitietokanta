<%-- 
    Document   : valmistaja
    Created on : 16.8.2015, 12:24:47
    Author     : Antero Oikkonen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>${pageTitle}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.css" rel="stylesheet">
        <link href="bootstrap-theme.css" rel="stylesheet">
        <link href="main.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="bootstrap.min.js"></script>
    </head>
    <body>
         <div class="container">
            <c:if test="${pageError != null}">
                <div class="alert alert-danger">${pageError}</div>
            </c:if>
         </div>
        <form>
            <input type="hidden" name="uid" value="${valmistaja.uid}"></hidden>
        <div>
            valmistaja
            <input type="text" name="nimi" value="${valmistaja.nimi}">

            paikkakunta
            <input type="text" name="paikkakunta" value="${valmistaja.paikkakunta}">
        </div>
        <div>
            <input type="submit" value="Tallenna">
            <input type="submit" value="Peru">
            <a href="PoistaValmistaja?uid=${valmistaja.uid}">poista valmistaja</a>
        </div>
    </form>
</body>
</html>
