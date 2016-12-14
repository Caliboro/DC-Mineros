
package Vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Logeo", urlPatterns = {"/Logeo"})
public class Logeo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Logeo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action= Usuario_cont method='post' />");
            out.println("Usuario");
            out.println("<input type='text' name='usuario'/>");
            out.println("Constraseña");        
            out.println("<input type='text' name='contrasena'/>");
            out.println("<input type='submit' name='ingresa_usuario'/>");
            out.println("</form>");
            String error = (String)request.getAttribute("error"); 
            if (error != null)  out.println("<font size=4 color=red>"+error+"</font>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
