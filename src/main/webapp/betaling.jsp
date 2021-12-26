<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %>
<%@ page import="bacit.web.bacit_web.Modell.UtstyrM" %><%--
  Created by IntelliJ IDEA.
  User: Ms-ka
  Date: 12/15/2021
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<%
    AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
    if (null == ansattM) {
        response.sendRedirect("index.jsp");
    }
    request.getAttribute("utstyr");
    UtstyrM utstyrM1 = (UtstyrM) request.getAttribute("utstyrM1");
%>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>
<div class="container">
    <h2>Kvittering</h2>
    <table class="table table-striped">
        <thead>

        <tr>
            <th>ID-nummer</th>
            <th>UtstyrID</th>
            <th>Utstyren</th>
            <th>Leie fra</th>
            <th>Til</th>
            <th>TotalDager </th>
            <th>Total kostnad</th>
            <th>Leie_kostnad for en dag</th>

        </tr>
        </thead>
        <tbody>


            <tr>
                <td> <span> <%= ansattM.getAnsatt_id() %> </span>

                <td> <span> <%= utstyrM1.getUtstyr_id() %> </span>

                <td> <span> <%=utstyrM1.getUtstyr_navn() %> </span>
                </td>
                <td> <span> ${ start_leie } </span>
                </td>

                <td> <span> ${ tilbake } </span>
                </td>
                <td> <span> ${totalD } </span>
                </td>
                <td> <span> ${ totalP } </span>
                </td>
                <td> <span> <%=utstyrM1.getLeie_kostnad()%> </span>
                </td>
            </tr>



        </tbody>
    </table>

</div>

</body>
</html>
