<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %><%--
  Created by IntelliJ IDEA.
  User: Ms-ka
  Date: 11/13/2021
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <%
        AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
        if (null == ansattM) {
            response.sendRedirect("index.jsp");
        }
    %>
</head>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>
<form method="POST" action="FileUploadServlet" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Leie  ID</td>
            <td><input type="text" name="leaseId"/></td>
        <tr>
            <td>Leie Pdf</td>
            <td><input type="file"  name="file" id="file"/></td>
        </tr>
    </table>
</form>
</body>
</html>
