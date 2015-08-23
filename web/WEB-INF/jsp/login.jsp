<%-- 
    Document   : login
    Created on : 4.8.2015, 11:07:04
    Author     : Antero Oikkonen
--%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Tankin tiedot">
    <form action="login" method="POST">
        Käyttäjänimi: <input type="text" name="username" />
        Salasana: <input type="password" name="password" />
        <button type="submit">Kirjaudu</button>
    </form>
</t:pohja>
