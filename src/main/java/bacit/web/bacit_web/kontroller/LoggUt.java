package bacit.web.bacit_web.kontroller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/LoggUt")
public class LoggUt extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        HttpSession session = request.getSession();
        session.removeAttribute("ansatt");

        res.sendRedirect("index.jsp");
    }
}