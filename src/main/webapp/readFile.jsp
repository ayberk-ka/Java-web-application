<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %><%--
  Created by IntelliJ IDEA.
  User: Ms-ka
  Date: 11/13/2021
  Time: 12:26 PM
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

<form method="get" action="FileReadPdfServlet">
    <table>
        <tr>
            <td>Tast inn leie Id</td>
            <td>
                <input type="text" name="leaseId" id="leaseId"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Hent leiekontrakten"/></td>
        </tr>
    </table>
</form>
</body>
</html>
