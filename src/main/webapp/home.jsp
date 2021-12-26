<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %><%--
  Created by IntelliJ IDEA.
  User: Ms-ka
  Date: 11/11/2021
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
    if (1 == ansattM.getAdminstrator()) {
        out.println("Admin side");
    }

%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home page</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>
<div>
    <h1 class="text-center text-danger"><span id="errorMessage">${param.errorMessage}</span></h1>

    <p>
     Velkommen <b><%=ansattM.getFornavn() + " " + ansattM.getEtternavn()%></b>
    </p>

</div>
</body>
</html>
