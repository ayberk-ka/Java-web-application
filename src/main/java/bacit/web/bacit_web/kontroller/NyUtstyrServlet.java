
package bacit.web.bacit_web.kontroller;
import bacit.web.bacit_web.DAO.UtstyrDAO;
import bacit.web.bacit_web.Modell.UtstyrM;
import bacit.web.bacit_web.Modell.UtstyrTypeM;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NyUtstyrServlet")
public class NyUtstyrServlet extends HttpServlet {

    public NyUtstyrServlet() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO Auto-generated constructor stub
        response.setContentType("text/html");
        UtstyrDAO utstyrDAO = new UtstyrDAO();
        PrintWriter printWriter = response.getWriter();
        try {
            ArrayList<UtstyrTypeM> utstyType = utstyrDAO.getUtstyType(printWriter);
            request.setAttribute("utstyType", utstyType);  // vi har request til jsp og gi Attribute Parameter (utstyrType) fra utstyrType arry
            request.getRequestDispatcher("nyUtstyr.jsp").forward(request, response); // send og flyte videre til jsp
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        Boolean status = false;
     // her skal sjekke på alle parametere av request i form hvis Status funnet så får tilbake true hivs ikke får false
        if (request.getParameterMap().containsKey("status")) {
            status = true;
        }

        UtstyrM utstyr = new UtstyrM(
                //Her brukte parseInt for å forandre return av getparameter fra String til integer
                Integer.parseInt(request.getParameter("utstyr_type_id")),
                status,
                Float.parseFloat(request.getParameter("leie_kostnad")),
                request.getParameter("utstyr_navn"),
                request.getParameter("bruk_info")
        );


        try {
            UtstyrDAO utstyrDAO = new UtstyrDAO();
// Her lagre alle result på saveUtstyr metode hvis og får return true til seccses hvis data lagret
            Boolean succses= utstyrDAO.saveUtstyr(utstyr, printWriter);
            if (succses==true) {

                printWriter.println("<script>window.location.href = \"UtstyrServlet\" </script>");
            }
else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            printWriter.println("ERROR " + e.getMessage());
        }
    }

}
