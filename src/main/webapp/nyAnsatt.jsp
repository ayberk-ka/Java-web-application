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
    <title>Ny Ansatt</title>
    <%
        AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
        if (0 == ansattM.getAdminstrator()) {
            response.sendRedirect("home.jsp?errorMessage=" +
                    URLEncoder.encode("Du har ikke tillatelse til å legge til en ny Ansatt", "UTF-8"));
        }
    %>
</head>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>
<div class="container">
    <form id="ansattForm" action="NyAnsattServlet" method="post">
        <div class="form-group">
            <label for="fornavn">fornavn</label>
            <input type="text" class="form-control" id="fornavn" name="fornavn" aria-describedby="fornavn help" placeholder="Skriv fornavn">
        </div>
        <div class="form-group">

            <label for="etternavn">etternavn</label>
            <input type="text" class="form-control" id="etternavn" name="etternavn" aria-describedby="etternavn help" placeholder="Skriv etternavn">
        </div>

        <div class="form-group">
            <label for="email">email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="email">
        </div>

        <div class="form-group">
            <label for="password">password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="password">
        </div>

        <div class="form-group">
            <label for="addresse">addresse</label>
            <input type="text" class="form-control" id="addresse" name="addresse" placeholder="addresse">
        </div>

        <div class="form-group">
            <label for="mobil">mobil</label>
            <input type="text" class="form-control" id="mobil" name="mobil" placeholder="mobil">
        </div>

        <div class="form-group">
            <label for="administrator">administrator</label>
            <input type="number" class="form-control" id="administrator" name="administrator" placeholder="administrator">
        </div>

        <div class="form-group">
            <label for="unionn">unionn</label>
            <input type="number" class="form-control" id="unionn" name="unionn" placeholder="unionn">
        </div>
        <button type="submit" class="btn btn-primary">Lagre</button>
    </form>
</div>
</body>
</html>
