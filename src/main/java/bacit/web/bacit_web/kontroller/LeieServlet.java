/*
package bacit.web.bacit_web.kontroller;
import bacit.web.bacit_web.DAO.AnsattDAO;
import bacit.web.bacit_web.DAO.LeieDAO;
import bacit.web.bacit_web.DAO.UtstyrDAO;
import bacit.web.bacit_web.Modell.AnsattM;
import bacit.web.bacit_web.Modell.LeieM;
import bacit.web.bacit_web.Modell.UtstyrM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;


@WebServlet("/LeieServlet")



public class LeieServlet extends HttpServlet {

    public LeieServlet()  {

    }




    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String start_leie_dato= request.getParameter("start_leie_dato");
        String tilbake_dato= request.getParameter("tilbake_dato");
        String pris = request.getParameter("total_kostnad");
        String utstID = request.getParameter("utstyr_id");
        int totalD;
        Float totalP;
        Boolean betalt = false;
        // her skal sjekke på alle parametere av request i form hvis Status funnet så får tilbake true hivs ikke får false
        if (request.getParameterMap().containsKey("betalt")) {
            betalt = true;
        }




        try {
            LocalDate start_leie = LocalDate.parse(start_leie_dato);
            LocalDate tilbake = LocalDate.parse(tilbake_dato);
            float Pris = Float.parseFloat(pris);
            int utstyr_id =  Integer.parseInt(utstID);



                    LeieM leieM = new LeieM(
                    Integer.parseInt(request.getParameter("ansatt_id")),
                    Integer.parseInt(request.getParameter("utstyr_id")),
                    start_leie,
                    tilbake,
                    betalt,
                    Float.parseFloat(request.getParameter("total_kostnad")),
                    request.getParameter("tilstandsvurdering")

            );
                 UtstyrM utstyrM = new UtstyrM(
                         utstyr_id


                         );
            UtstyrDAO utstyrDAO = new UtstyrDAO();
            UtstyrM utstyrM1 = utstyrDAO.getUtstyR(utstyr_id,printWriter);
            if (utstyrM1 != null){
                request.setAttribute("utstyrM1", utstyrM1);
            }

                // gi attribute til total og sende til jsp
            totalD = (int) (tilbake.toEpochDay() - start_leie.toEpochDay());
            totalP = (float) totalD * Pris;

            request.setAttribute("totalD",totalD);
            request.setAttribute("tilbake",tilbake);
            request.setAttribute("start_leie",start_leie);
            request.setAttribute("totalP",totalP);



            LeieDAO leieDAO = new LeieDAO();
            boolean succses= leieDAO.saveLeie(leieM, printWriter);
            if (succses==true) {

                request.getRequestDispatcher("betaling.jsp").forward(request, response);
            }
            else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException | ServletException e) {
            printWriter.println(e.getMessage());

        }
    }

}


  //  LocalDate start_leie = LocalDate.parse(start_leie_dato);
   // LocalDate tilbake = LocalDate.parse(tilbake_dato);*/
