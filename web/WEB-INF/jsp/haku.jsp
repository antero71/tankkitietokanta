<%-- 
    Document   : haku
    Created on : 16.8.2015, 9:35:21
    Author     : Antero Oikkonen
--%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Tankin tiedot">
    <form>

        hae nimellä
        <input type="text" name="hakukentta">
        <div>
            <input type="submit" value="Hae">
            <input type="submit" value="Peru">
        </div>
    </form>
</t:pohja>