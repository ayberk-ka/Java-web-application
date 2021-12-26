<%@ page import="java.util.ArrayList" %>
<%@ page import="bacit.web.bacit_web.Modell.UtstyrTypeM" %>
<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Ms-ka
  Date: 11/8/2021
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ny Utstyr</title>
  <%
    AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
    if (0 == ansattM.getAdminstrator()) {
      response.sendRedirect("home.jsp?errorMessage=" +
              URLEncoder.encode("Du har ikke tillatelse til å legge til en ny Utstyr", "UTF-8"));

    }
  %>
</head>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>
<% ArrayList<UtstyrTypeM>  utstyType = (ArrayList) request.getAttribute("utstyType");    %>
<div class="container">
<form id="utstyrForm" action="NyUtstyrServlet" method="post">
  <div class="form-group">
    <label for="utstyr_navn">Utstyr navn</label>
    <input type="text" class="form-control" id="utstyr_navn" name="utstyr_navn" aria-describedby="utstyr navn help" placeholder="Legge til utstyr navn">
  </div>
  <div class="form-group">
    <label for="utstyr_type_id">Utstyr type navn</label>
    <select id="utstyr_type_id" name="utstyr_type_id" class="form-select" aria-label="select">
      <option selected>Åpne meny for valg av utstyr type</option>
      <%   for(UtstyrTypeM u : utstyType) { %>
      <option value=<%=u.getUtstyr_type_id()%>><%=u.getUtstyr_type_navn()%></option>
      <% }%>
    </select>  <div class="form-group">
  </div>

    <label for="leie_kostnad">Leie kostnad</label>
    <input type="number" class="form-control" id="leie_kostnad" name="leie_kostnad" aria-describedby="leie_kostnad" placeholder="Legge leie kostnad">
  </div>

  <div class="form-group">
    <label for="bruk_info">Bruk info</label>
    <input type="text" class="form-control" id="bruk_info" name="bruk_info" placeholder="Bruk info">
  </div>
  <div class="form-check">
    <label class="form-check-label" for="status">Den er Opptatt</label>
    <input type="checkbox" class="form-check-input" id="status" name="status">
  </div>
  <button type="submit" class="btn btn-primary">Lagre</button>
</form>
</div>
</body>
</html>
