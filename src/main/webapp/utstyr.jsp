<%@ page import="bacit.web.bacit_web.Modell.UtstyrM" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Utstyr List</title>

</head>
<%
    AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
    if (null == ansattM) {
        response.sendRedirect("index.jsp");
    }
    ArrayList<UtstyrM> utstyr = (ArrayList<UtstyrM>) request.getAttribute("utstyr");

%>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>


    <h2>Ledig Utstyr</h2>
    <table class="table table-striped">
        <thead>

    <tr>
        <th>UtstyrID</th>
        <th>Utstyr typeID</th>
        <th>Navn</th>
        <th>Info</th>
        <th>leie_kostnad</th>

    </tr>
        </thead>
        <tbody>
        <form action="UtstyrServlet" method="GET">

        <%   for(UtstyrM u : utstyr) { %>
        <tr>
            <td> <span>  <%=u.getUtstyr_id()%></span>
            </td>
            <td> <span>  <%=u.getUtstyr_type_id()%></span>
            </td>

        <td> <b>  <%=u.getUtstyr_navn()%></b>
        </td>
        <td> <span>  <%=u.getBruk_info()%></span>
        </td>

            <td> <span>  <%=u.getLeie_kostnad()%></span>
            </td>
        </tr>
                <% }%>


        </form>


        </tbody>
</table>
<br>
<h2>Bestille Utstyr</h2>
</p>
<div class="container">


    <form action="UtstyrServlet" method="post">

        <div class="form-group">
            <label  for="utstyr_id" >Velg utstyr du ønsker å leie </label>
            <select id="utstyr_id"  name="utstyr_id"  class="form-select" aria-label="select" required placeholder=""
                    oninvalid="this.setCustomValidity(' Velg utstyr du ønsker å leie')"
                    oninput="this.setCustomValidity('')" >
                <option  value="" disabled selected> Åpne meny for å velge utstyr </option>
                <%   for(UtstyrM u : utstyr) { %>
                <option value=<%=u.getUtstyr_id()%>><%=u.getUtstyr_navn()%></option>
                <% }%>
            </select>  <div class="form-group">
        </div>


            <div class="form-group">
                <label for="ansatt_id">Ditt ID-nummer</label>
                <input type="text" class="form-control" id="ansatt_id" name="ansatt_id" value="<%=ansattM.getAnsatt_id()%>" readonly>
            </div>

            <div class="form-group">
                <label for="ansatt_fornavn">Fornavn</label>
                <input type="text" class="form-control" id="ansatt_fornavn" name="ansatt_fornavn"
                       value="<%=ansattM.getFornavn()%>" readonly>
            </div>

            <div class="form-group">
                <label for="ansatt_etternavn">Etternavn</label>
                <input type="text" class="form-control" id="ansatt_etternavn" name="ansatt_etternavn"
                       value="<%=ansattM.getEtternavn() %>" readonly>
            </div>

            <div class="form-group">
                <label for="ansatt_addresse">Addresse</label>
                <input type="text" class="form-control" id="ansatt_addresse" name="ansatt_addresse"
                       value="<%=ansattM.getAddresse() %>" readonly>
            </div>

            <label for="start_leie_dato">Leie fra</label>
            <input type="date" class="form-control" id="start_leie_dato" name="start_leie_dato" aria-describedby="start_leie_dato help" placeholder="Start leie" required placeholder=""
                   oninvalid="this.setCustomValidity(' Velg dato du ønsker å leie')"
                   oninput="this.setCustomValidity('')">
        </div>

        <div class="form-group">
            <label for="tilbake_dato">Leie til</label>
            <input type="date" class="form-control" id="tilbake_dato" name="tilbake_dato" placeholder="Tilbake dato" required placeholder=""
                   oninvalid="this.setCustomValidity(' Velg dato du ønsker å levere utstyr tilbake')"
                   oninput="this.setCustomValidity('')">
        </div>


        <div class="form-group">
            <label for="tilstandsvurdering">skriv inn kommentar</label>
            <input type="text" class="form-control" id="tilstandsvurdering" name="tilstandsvurdering"  placeholder="kommentar" >

        </div>
        <br>
        <h6>trykk for å betale nå</h6>
        </p>
        <div class="form-check">
            <label class="form-check-label" for="betalt">Betal nå</label>
            <input type="checkbox" class="form-check-input" id="betalt" name="betalt">
        </div>

        <button type="submit" class="btn btn-primary" >Bestill </button>

    </form>



</div>
</body>
</html>