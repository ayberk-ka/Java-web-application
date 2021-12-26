package bacit.web.bacit_web.kontroller;
import bacit.web.bacit_web.DAO.AnsattDAO;
import bacit.web.bacit_web.Modell.AnsattM;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static bacit.web.bacit_web.PasswordEncrypting.encrypt;

@WebServlet("/NyAnsattServlet")
public class NyAnsattServlet extends HttpServlet {

    public NyAnsattServlet()  {

    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
String password = request.getParameter("password");
String encrpPassword = encrypt(password);




        AnsattM ansattM = new AnsattM(
                encrpPassword,
                request.getParameter("fornavn"),
                request.getParameter("etternavn"),
                request.getParameter("email"),
                request.getParameter("addresse"),
                request.getParameter("mobil"),
                Integer.parseInt(request.getParameter("administrator")),
                Integer.parseInt(request.getParameter("unionn"))

                );


        try {
            AnsattDAO ansattDAO = new AnsattDAO();
            Boolean succses= ansattDAO.saveUser(ansattM, printWriter);
            if (succses==true) {

                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            printWriter.println("ERROR " + e.getMessage());
        }
    }

}


