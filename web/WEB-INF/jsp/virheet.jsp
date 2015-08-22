<%-- 
    Document   : virheet
    Created on : 16.8.2015, 11:13:21
    Author     : Antero Oikkonen
--%>

 <c:if test="${virheViesti != null}">
  <div class="alert alert-danger">Virhe! ${virheViesti}</div>
</c:if>