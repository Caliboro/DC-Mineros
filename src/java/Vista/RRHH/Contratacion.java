/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.RRHH;

import Controlador.Trabajador_controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thebe
 */
@WebServlet(name = "Contratacion", urlPatterns = {"/Contratacion"})
public class Contratacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("/faces/header.jsp").include(request, response);
        try {
            
            ArrayList regiones = new ArrayList();
            ArrayList provincia = new ArrayList();
            ArrayList comuna = new ArrayList();
            ArrayList contrato = new ArrayList();
            Trabajador_controlador tc = new Trabajador_controlador();
            regiones = tc.cargar_region("REGION");
            provincia = tc.cargar_region("PROVINCIA");
            comuna = tc.cargar_region("COMUNA");
            contrato = tc.cargar_contrato();
            
//<editor-fold defaultstate="collapsed" desc="base html">
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            
out.println("<title>Servlet Contratacion</title>");
out.println("</head>");
out.println("<body>");
//</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Datos Personales">
            out.println("</br>");
            out.println("<div class='col-md-6'>");
            out.println("<h1>Datos Personales</h1>");    
                out.println("<form action= 'Trabajador_controlador' method='post' class='form-inline'/>");
           
                
            out.println("<table>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Nombre: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='nombre' />");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");    
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Rut: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='rut' />");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Fecha Nacimiento: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='fecha_nacimiento' />");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Celular: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='celular' />");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Correo Electrónico: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='email' />");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<label>Sexo: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<div class='radio'>");
                    out.println("<label><input type='radio' value='true' name='sexo' />Femenino</label> ");
                    out.println("</div>");
                    out.println("<div class='radio'>");
                    out.println("<label><input type='radio' value='false' name='sexo' />Masculino</label>");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Domicilio:</label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='domicilio' />");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Comuna: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<select type='text' name='comuna' />");
                    String region;
                    for(int i=0; i<comuna.size();i++){
                       region = comuna.get(i).toString();
                    out.println("<option value="+region+">"+region+"</option>");
                    }
                    out.println("</select>");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Provincia: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<select type='text' name='provincia' />");
                    for(int i=0; i<provincia.size();i++){
                       region = provincia.get(i).toString();
                    out.println("<option value="+region+">"+region+"</option>");
                    }
                    out.println("</select>"
                            + "</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                        out.println("<label>Region: </label>");
                out.println("</td>");
                out.println("<td>");
                        out.println("<select type='text' name='region' />");
                        for(int i=0; i<regiones.size();i++){
                            region = regiones.get(i).toString();
                            out.println("<option value="+region+">"+region+"</option>");
                        }
                    out.println("</select></div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>");
                    out.println("<div class='form-group'>");
                    out.println("<label>Nacionalidad: </label>");
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type='text' name='nacionalidad' />");
                    out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
            out.println("</table>");    
            out.println("</div>");
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Datos Profesionales">
out.println("<div class='col-md-6'>");
out.println("<h1>Datos Profesionales</h1>");

out.println("<table>");
out.println("<tr>");
out.println("<td>");
    out.println("<div class='form-group'>");
    out.println("<label>Cargo: </label>");
out.println("</td>");
out.println("<td>");
    out.println("<input type='text' name='cargo' />");
    out.println("</div>");
out.println("</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>");
    out.println("<div class='form-group'>");
    out.println("<label>Turno: </label>");
out.println("</td>");
out.println("<td>");
    out.println("<input type='text' name='turno' />");
    out.println("</div>");
out.println("</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>");
    out.println("<div class='form-group'>");
    out.println("<label>Jornada: </label>");
out.println("</td>");
out.println("<td>");
    out.println("<input type='text' name='jornada' />");
    out.println("</div>");
out.println("</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>");
    out.println("<div class='form-group'>");
    out.println("<label>Salario: </label>");
out.println("</td>");
out.println("<td>");
    out.println("<input type='text' name='salario' />");
    out.println("</div>");
out.println("</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>");
    out.println("<div class='form-group'>");
    out.println("<label>Contrato Asociado: </label>");
out.println("</td>");
out.println("<td>");
    out.println("<select type='text' name='contrato_asociado' />");

    for(int i=0; i<contrato.size();i++){
                   region = contrato.get(i).toString();
                out.println("<option value="+region+">"+region+"</option>");
                }

    out.println("</select></div>");
out.println("</td>");
    out.println("</tr>");
out.println("</table>");
out.println("</div>");
//</editor-fold>
            
            out.println("<div class='panel-default'>");
            out.println("<div class='form-group'>");
            out.println("<input type='text' name='servlet' value='Avance_obras' placeholder='Avance_obras' style='visibility:hidden'>");
            out.println("<p><input type='submit' name='Ingresafecha' value='Ingresar Trabajador' class='btn btn-primary'/></p>"); 
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
            String mensaje = request.getAttribute("error").toString();
            String [] campos = mensaje.split("[?]");
            if(campos.length > 0){
                out.println("<div class= panel panel-danger>");
                out.println("<div class= panel panel-heading>Los Siguientes Campos no se han Ingresado Correctamente</div>");
                out.println("<div class= panel-body>");
                for(int i=0; i<campos.length; i++){
                    
                    out.println("<label>"+campos[i]+",</label>");
                }
                out.println("</div>");
                out.println("</div>");
            }
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
        //<editor-fold defaultstate="collapsed" desc="Base HTML">
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Contratacion</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Contratacion at " + request.getContextPath() + "</h1>");
//</editor-fold>
            
            
           
            
            
            out.println("</body>");
            out.println("</html>");
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
