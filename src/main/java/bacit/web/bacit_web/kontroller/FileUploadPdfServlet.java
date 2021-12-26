package bacit.web.bacit_web.kontroller;

import bacit.web.bacit_web.DAO.FileDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig

public class FileUploadPdfServlet extends HttpServlet {

    public FileUploadPdfServlet(){

    }
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO Auto-generated constructor stub
        response.setContentType("text/html");
        try {
            request.getRequestDispatcher("uploadFile.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        final Part filePart = request.getPart("file");
        String leaseId = request.getParameter("leaseId");

        InputStream pdfFileBytes = null;
        final PrintWriter printWriter = response.getWriter();

        try {
            if (!filePart.getContentType().equals("application/pdf")) {
                printWriter.println("<br/> Invalid File");
                return;
            } else if (filePart.getSize() > 1048576) { //2mb
                {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                    requestDispatcher.include(request, response);
                    printWriter.println("<br/> File size too big");

                    return;
                }
            }

            //her vi endrer  pdfFile til byte
            pdfFileBytes = filePart.getInputStream();

            final byte[] bytes = new byte[pdfFileBytes.available()];
            pdfFileBytes.read(bytes);

            FileDAO fileDAO = new FileDAO();
         //Her vi etter at vi endret pdf til byte setet byte som parameter på metode uploadFile til å lagere på database
            int success = fileDAO.uploadFile(leaseId, bytes, printWriter);

            if(success>0) {
                request.getRequestDispatcher("readFile.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // vi brukte finally for å close pdfFileBytes og printWriter for å clean minner
        finally {

            if (pdfFileBytes != null) {
                pdfFileBytes.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }

}
