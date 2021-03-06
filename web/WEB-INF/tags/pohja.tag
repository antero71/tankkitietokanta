<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@tag description="Generic template for Tankkitietokanta pages" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="pageTitle"%>
<!DOCTYPE html>
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
        <div class="navbar navbar-default">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="etusivu">Etusivu</a></li>
                    <li class="active"><a href="TankkienListaus">Listaa tankit</a></li>
                    <li class="active"><a href="TankinHaku?hae=true">Tankin haku</a></li>
                    <li class="active"><a href="Logout">Kirjaudu ulos</a></li>
                    <li class="active"><a href="login">kirjaudu sisään</a></li>
                </ul>
            </div>
        </div>

        <div class="container">
            <c:if test="${pageError != null}">
                <div class="alert alert-danger">${pageError}</div>
            </c:if>
            <c:if test="${ilmoitus != null}">
                <div class="ilmoitus">${ilmoitus}</div>
            </c:if>
            <jsp:doBody/>
        </div>
    </body>
</html>
