<%-- 
    Document   : etusivuEiKirjautunut
    Created on : 7.8.2015, 14:12:09
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
        <jsp:include page="header.jsp"></jsp:include>ß
        <div>
            <a href="TankkiServlet?hae=true">Tankin haku</a>
        </div>
        <div>
            <a href="TankkiServlet">Listaa tankit</a>
        </div>
    </body>
</html>
