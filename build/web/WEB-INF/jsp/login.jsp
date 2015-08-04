<%-- 
    Document   : login
    Created on : 4.8.2015, 11:07:04
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
        <form action="LoginServlet" method="POST">
            Käyttäjänimi: <input type="text" name="username" />
            Salasana: <input type="password" name="password" />
            <button type="submit">Kirjaudu</button>
        </form>
    </body>
</html>
