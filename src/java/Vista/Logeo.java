
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
            request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            
            
            out.println("<body class='full'>");
                out.println("<div class=\"container\">");        
                out.println("<div class=\"row\">");
                    out.println("<div class=\"col-md-6 col-sm-12\">");
                            
                            out.println("<h1>DC Mineros</h1>");
                            out.println("<p>DC Mineros es una plataforma dedicada a mejorar las necesidades documentales en los contratos que sostienen las empresas actuales dentro del rubro minero, apoyando la gestión de documentos y del Recurso Humano dentro de la empresa a través de diferentes recursos.</p>");
                            out.println("<p>Para ingresar a DC Mineros, Click en");
                            out.println("<a href='#' data-toggle='modal' data-target='#login-modal'>Comenzar </a></p>");
                            String error = (String)request.getAttribute("error"); 
                            if (error != null)  out.println("<p color=red>"+error+"</p>");
            //<editor-fold defaultstate="collapsed" desc="formulario">
            out.println("<div class='modal fade' id='login-modal' tabindex='-1' role='dialog' aria-hidden='true' style='display: none;'>");
            out.println("<div class='modal-dialog'>");
            out.println("<div class='loginmodal-container'>");
            out.println("<h1>Ingresar a DC Mineros</h1>");
            out.println("<form action= Usuario_cont method='post'>");
            out.println("<input type='text' name='usuario' placeholder='Usuario'/>");
            out.println("<input type='password' name='contrasena' placeholder='Contraseña'/>");
            out.println("<input type='submit' name='ingresa_usuario' value='Ingresar' class='login loginmodal-submit'/>");
            out.println("</form>");
            
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
//</editor-fold>
                    out.println("</div>");
                out.println("</div>");
                out.println("</div>");

            
          
            
            //request.getRequestDispatcher("/WEB-INF/jspf/bottom.jspf").include(request,response);
            out.println("</div>");
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
