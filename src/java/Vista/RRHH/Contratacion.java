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
out.println("<title>Servlet Contratacion</title>");
out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet Contratacion at " + request.getContextPath() + "</h1>");
//</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Datos Personales">
            out.println("<div>");
            out.println("<h1>Datos Personales</h1>");
            out.println("<form action= 'Trabajador_controlador' method='post' />");
           
            out.println("<table>");
            
            out.println("<tr>");
            out.println("<th>Nombre: </th>");
            out.println("<th><input type='text' name='nombre' /></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Rut: </th>");
            out.println("<th><input type='text' name='rut' /></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Fecha Nacimiento: </th>");
            out.println("<th><input type='text' name='fecha_nacimiento' /></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Celular: </th>");
            out.println("<th><input type='text' name='celular' /></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Correo Electrónico: </th>");
            out.println("<th><input type='text' name='email' /></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Sexo: </th>");
            out.println("<th>Femenino: <input type='radio' value='true' name='sexo' /></th>");
            out.println("<th>Masculino: <input type='radio' value='false' name='sexo' /></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Domicilio: </th>");
            out.println("<th><input type='text' name='domicilio' /></th>");
            out.println("<th>Comuna: </th>");
            out.println("<th><select type='text' name='comuna' />");
            
            String region;
            for(int i=0; i<comuna.size();i++){
               region = comuna.get(i).toString();
            out.println("<option value="+region+">"+region+"</option>");
            }
            
            out.println("</select></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Provincia: </th>");
            out.println("<th><select type='text' name='provincia' />");
            
            for(int i=0; i<provincia.size();i++){
               region = provincia.get(i).toString();
            out.println("<option value="+region+">"+region+"</option>");
            }
            
            out.println("</select></th>");
            out.println("<th>Region: </th>");
            out.println("<th><select type='text' name='region' />");
            
            for(int i=0; i<regiones.size();i++){
               region = regiones.get(i).toString();
            out.println("<option value="+region+">"+region+"</option>");
            }
            
            out.println("</select></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>Nacionalidad: </th>");
            out.println("<th><input type='text' name='nacionalidad' /></th>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Datos Profesionales">
out.println("<div>");
out.println("<h1>Datos Profesionales</h1>");

out.println("<table>");

out.println("<tr>");
out.println("<th>Cargo: </th>");
out.println("<th><input type='text' name='cargo' /></th>");
out.println("</tr>");
out.println("<tr>");
out.println("<th>Turno: </th>");
out.println("<th><input type='text' name='turno' /></th>");
out.println("</tr>");
out.println("<tr>");
out.println("<th>Jornada: </th>");
out.println("<th><input type='text' name='jornada' /></th>");
out.println("</tr>");
out.println("<tr>");
out.println("<th>Salario: </th>");
out.println("<th><input type='text' name='salario' /></th>");
out.println("</tr>");
out.println("<tr>");
out.println("<th>Contrato Asociado: </th>");
out.println("<th><select type='text' name='contrato_asociado' />");

for(int i=0; i<contrato.size();i++){
               region = contrato.get(i).toString();
            out.println("<option value="+region+">"+region+"</option>");
            }

out.println("</select></th>");
out.println("</tr>");
out.println("</table>");
out.println("</div>");
//</editor-fold>
            
            
            out.println("<input type='text' name='servlet' value='Avance_obras' placeholder='Avance_obras' style='visibility:hidden'>");
            out.println("<p><input type='submit' name='Ingresafecha'/></p>"); 
            out.println("</form>");
            
            
            String mensaje = request.getAttribute("error").toString();
            String [] campos = mensaje.split("[?]");
            if(campos.length > 0){
                out.println("<div>");
                //out.println("Los Siguientes Campos no se han Ingresado Correctamente");
                for(int i=0; i<campos.length; i++){
                    
                    out.println("<p>"+campos[i]+"</p>");
                }
                out.println("</div>");
            }
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
