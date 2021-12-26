package bacit.web.bacit_web.kontroller;
import bacit.web.bacit_web.DAO.LeieDAO;
import bacit.web.bacit_web.DAO.UtstyrDAO;
import bacit.web.bacit_web.Modell.AnsattM;
import bacit.web.bacit_web.Modell.LeieM;
import bacit.web.bacit_web.Modell.UtstyrM;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UtstyrServlet")
public class UtstyrServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UtstyrServlet() {

        //TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO Auto-generated constructor stub

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        UtstyrDAO utstyrDAO = new UtstyrDAO();



        try {
            ArrayList<UtstyrM> utstyr = utstyrDAO.getUtsty(false, printWriter); // her hentet Utstyr fra DB

            request.setAttribute("utstyr", utstyr);  // vi har request og gi Attribute Parameter (utstyr) fra utstyr

            if (utstyr != null) {
                request.getRequestDispatcher("utstyr.jsp").forward(request, response); // send og flyte videre til jsp

            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String start_leie_dato = request.getParameter("start_leie_dato");
        String tilbake_dato = request.getParameter("tilbake_dato");
        String utstID = request.getParameter("utstyr_id");
        Boolean betalt = false;
        // her skal sjekke på alle parametere av request i form hvis Status funnet så får tilbake true hivs ikke får false
        if (request.getParameterMap().containsKey("betalt")) {
            betalt = true;
        }

        int totalD;
        float totalP;

        try {
            LocalDate start_leie = LocalDate.parse(start_leie_dato);
            LocalDate tilbake = LocalDate.parse(tilbake_dato);
            int utstyr_id = Integer.parseInt(utstID);




            UtstyrDAO utstyr2DAO = new UtstyrDAO();
            UtstyrM utstyrM1 = utstyr2DAO.getUtstyR(utstyr_id, printWriter);
            if (utstyrM1 != null) {
                request.setAttribute("utstyrM1", utstyrM1);
            }
            float ps= utstyrM1.getLeie_kostnad();
            // gi attribute til total og sende til jsp

            totalD = (int) (tilbake.toEpochDay() - start_leie.toEpochDay());
            totalP = (float) totalD * ps;

            request.setAttribute("totalD", totalD);
            request.setAttribute("tilbake", tilbake);
            request.setAttribute("start_leie", start_leie);
            request.setAttribute("totalP", totalP);
            if (utstyrM1 != null) {
                request.getRequestDispatcher("betaling.jsp").forward(request, response);
            }
 // تسجيل رقم المستخدم المستأجر في قواعد البيانات عن طريق السيشين استخدمنا false حتى يرجع 0 اذا لايوجد سيشين
            HttpSession session=request.getSession(false);
            AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");

            LeieM leieM = new LeieM(
                    ansattM.getAnsatt_id(),
                    Integer.parseInt(request.getParameter("utstyr_id")),
                    start_leie,
                    tilbake,
                    betalt,
                    totalP,
                    request.getParameter("tilstandsvurdering")

            );

            LeieDAO leieDAO = new LeieDAO();
            boolean succses = leieDAO.saveLeie(leieM, printWriter);
            if (succses == true) {

                request.getRequestDispatcher("betaling.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException | ServletException e) {
            printWriter.println(e.getMessage());

        }


    }

}