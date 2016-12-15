package Vista.RRHH;

import Modelo.Trabajador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Documentos_trabajador", urlPatterns = {"/Documentos_trabajador"})
public class Documentos_trabajador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("/faces/header.jsp").include(request, response);
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            
            out.println("<title>Servlet Documentos_trabajador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Documentos Trabajador</h1>");
             out.println("<h1>Ingrese Rut del Trabajador a Buscar</h1>");
            out.println("<form action='Documentos' method='post'>");
                    
                 out.println("<input type='text' name='rut'>");
                 out.println("<input type='submit' name='ingresar'>");
                 
            
            out.println("</form>");
            
            ArrayList <Trabajador> documentos = new ArrayList <Trabajador>();
            documentos = (ArrayList <Trabajador>) request.getAttribute("error");
            Trabajador trabajador = new Trabajador();
            
            out.println("<table>");
            
            out.println("<tr>");
            out.println("<td>Nombre Documento</td>");
            out.println("<td>Tipo Documento</td>");
            out.println("<td>Fecha Vencimiento</td>");
            out.println("</tr>");
            
            for(int i=0; i< documentos.size(); i++){
            
                trabajador = documentos.get(i);
                out.println("<tr>");
                    out.println("<td>"+trabajador.getDoc().getNombre_documento()+"</td>");
                    out.println("<td>"+trabajador.getDoc().getTipo_documento()+"</td>");
                    out.println("<td>"+trabajador.getDoc().getFehca_vencimiento()+"</td>");
                out.println("</tr>");
                
            
            }
            
            out.println("</table>");
            request.getRequestDispatcher("/WEB-INF/jspf/bottom.jspf").include(request,response);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
