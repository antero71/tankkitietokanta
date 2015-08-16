<%-- 
    Document   : etusivuKirjautunut
    Created on : 7.8.2015, 14:11:53
    Author     : Antero Oikkonen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div>
            <a href="tankinyllapito.html">Tankin lisäys</a>
        </div>
        <div>
            <a href="TankkiServlet?hae=true">Tankin haku</a>
        </div>
        <div>
            <a href="TankkiServlet?lista=true">Listaa tankit</a>
        </div>
        <div>
            <a href="valmistajanYllapito.html">Lisää valistaja</a>
        </div>
        <div>
            <a href="tankinvalmistaja.html">Tankin valmistaja</a>
        </div>
    </body>
</html>
