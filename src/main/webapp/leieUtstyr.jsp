<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %>
<%@ page import="bacit.web.bacit_web.Modell.UtstyrM" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Ms-ka
  Date: 11/25/2021
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");%>
<%
session.setAttribute("ansatt_id", ansattM.getAnsatt_id());
    if (null == ansattM) {
        response.sendRedirect("index.jsp");
    }

%>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <title>leieUtstyr</title>

</head>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>
<div class="container">

    <p>
        Velkommen <b><%=ansattM.getFornavn() + " " + ansattM.getEtternavn()%></b>
    </p>

    <form id="leieForm" action="LeieServlet" method="post">

        <div class="form-group">
            <label for="ansatt_id">ansattID</label>
            <input type="text" class="form-control" id="ansatt_id" name="ansatt_id" value="<%=ansattM.getAnsatt_id()%>" readonly>
        </div>

        <div class="form-group">
            <label for="utstyr_id">utstyrID</label>
            <input type="text" class="form-control" id="utstyr_id" name="utstyr_id" aria-describedby="utstyr_id help" placeholder="Skriv utstyrID nummer">
        </div>
        <div class="form-group">

            <label for="start_leie_dato">Start leie dato</label>
            <input type="date" class="form-control" id="start_leie_dato" name="start_leie_dato" aria-describedby="start_leie_dato help" placeholder="Start leie">
        </div>

        <div class="form-group">
            <label for="tilbake_dato">Tilbake dato</label>
            <input type="date" class="form-control" id="tilbake_dato" name="tilbake_dato" placeholder="Tilbake dato">
        </div>

        <div class="form-group">
            <label for="betalt">betale nå skriv 1 ikke 0</label>
            <input type="text" class="form-control" id="betalt" name="betalt" placeholder="betale nå skriv 1 ikke 0">
        </div>

        <div class="form-group">
            <label for="total_kostnad">total_kostnad</label>
            <input type="text" class="form-control" id="total_kostnad" name="total_kostnad" placeholder="total_kostnad">
        </div>

        <div class="form-group">
            <label for="tilstandsvurdering">tilstandsvurdering</label>
            <input type="text" class="form-control" id="tilstandsvurdering" name="tilstandsvurdering" placeholder="tilstandsvurdering">

        </div>
        <button type="submit" class="btn btn-primary">Lagre</button>
    </form>



</div>
</body>
</html>
