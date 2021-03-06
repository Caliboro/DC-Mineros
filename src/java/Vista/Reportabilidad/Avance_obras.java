/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Reportabilidad;

import Modelo.Contrato;
import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thebe
 */
@WebServlet(name = "Avance_obras", urlPatterns = {"/Avance_obras"})
public class Avance_obras extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     ArrayList <Contrato> contratos = null;
     ArrayList <Contrato> horas_trabajadores = new ArrayList <Contrato>();
     ArrayList <Contrato> horas_equipos = new ArrayList <Contrato>();
        
    //<editor-fold defaultstate="collapsed" desc="Instancias de Objetos">
        Contrato cont = new Contrato();
        Contrato trabajador = new Contrato();
        Contrato equipo = new Contrato();
//</editor-fold>
                
        //<editor-fold defaultstate="collapsed" desc="Base HTML">
        
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
request.getRequestDispatcher("/faces/header.jsp").include(request, response);

out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            
//out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
out.println("<title>Reporte Avance Obras</title>");
//out.println("<link href=\""+request.getContextPath()+"/Estilos/Estilos1.css\" rel=\"stylesheet\" type=\"text/css\">");
out.println("</head>");
out.println("<body>");
out.println("<div class='container-fluid'>");
out.println("<h1>Avance de Obras</h1>");
//</editor-fold>
           
            //<editor-fold defaultstate="collapsed" desc="Formulario de Fechas">
            
                out.println("<div class='panel panel-primary'>");
                    
                    out.println("<div class='panel-heading'>Ingrese Rango de Fechas</div>");
                        
                    out.println("<div class='panel-body'>");
                    
                        out.println("<form action= Obras_Servlet method='post' />");
                            out.println("<div class='form-group'>");
                                out.println("<label>Desde: <input type='text' name='desde' /</label>");
                            out.println("</div>");
                            out.println("<div class='form-group'>");
                                out.println("<label>Hasta: <input type='text' name= 'hasta' /></label>");
                            out.println("</div>");
                            out.println("<div class='form-group'>");
                                out.println("<input type='text' name='servlet' value='Avance_obras' placeholder='Avance_obras' style='visibility:hidden'>");
                            out.println("</div>");
                            out.println("<div class='form-group'>");
                                out.println("<input type='submit' name='Ingresafecha' class='btn btn-primary'/>");
                            out.println("</div>");
                        out.println("</form>");
                    
                    out.println("</div>");
                out.println("</div>");
            out.println("</div>");
            
//</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Inicio Despliegue Contratos">
            contratos = (ArrayList <Contrato>)request.getSession().getAttribute("contratos");
            int contador = 1;
            for(int i= 0 ; i<contratos.size() ; i++ ){
                
                cont = contratos.get(i);
                  String color;
                if( cont.getEstado_contrato().equals("Vigente") ) color = "#red";
                if( cont.getEstado_contrato().equals("Vencido")) color = "#B40404";
                if( cont.getEstado_contrato().equals("Por Vencer")) color = "#DBA901";
                if( cont.getEstado_contrato().equals("En Tramitación")) color = "#58ACFA";
                else color = "black";
               
                
                contador = contador+i;
                out.println("<a href='Obras_Servlet?var1="+cont.getFecha_inicio()+"?"+cont.getFecha_termino()+"?"+contador+"?Avance_obras' action= get>");
                out.println("<div id='contenedor_contratos' background-color:'"+color+"'>");
                out.println("<p id='contrato'>Contrato: "+cont.getNombre_contrato()+".</p>");
                out.println("<p id='contrato'>Estado: "+cont.getEstado_contrato()+".</p>");
                out.println("<p id='contrato'>Inicio Contrato: "+cont.getFecha_inicio()+".</p>");
                out.println("<p id='contrato'>Fin Contrato: "+cont.getFecha_termino()+".</p>");
                out.println("</div>");
                out.println("</a>");
            }
//</editor-fold>
           
    //<editor-fold defaultstate="collapsed" desc="Inicio Despliegue Información de Reporte Trabajadores">
horas_trabajadores = (ArrayList <Contrato>)request.getAttribute("trabajadores");

    if(horas_trabajadores.size()> 0){
        
        out.println("<div class='col-md-6'>");
        out.println("<table align='center'>");
        
        out.println("<tr>");
        
            out.println("<th class=\"tg-yw4l\">Número ODS</th>");
            out.println("<th class=\"tg-yw4l\">Avance Horas</th>");
        
        out.println("</tr>");
        
        for(int i = 0; i<horas_trabajadores.size();i++){
            
            trabajador = horas_trabajadores.get(i);
            
            out.println("<tr>");
            out.println("<td class=\"tg-6k2t\">"+trabajador.getNumeroOds()+"</td>");
            out.println("<td class=\"tg-6k2t\">"+trabajador.getAvanceHoras()+".</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
    }

//</editor-fold>
            
    //<editor-fold defaultstate="collapsed" desc="Inicio Despliegue Información de Reporte Equipos">
//out.println(horas_equipos.size());

horas_equipos = (ArrayList <Contrato>)request.getAttribute("equipos");
if(horas_equipos.size() > 0){
    out.println("<div class='col-md-6'>");
    out.println("<table align='center'>");
        
        out.println("<tr>");
            out.println("<th class=\"tg-yw4l\">Número ODS</th>");
            out.println("<th class=\"tg-yw4l\">Avance Horas</th>");
        out.println("</tr>");
        
        for(int i = 0; i<horas_equipos.size();i++){
            equipo = horas_equipos.get(i);
            out.println("<tr>");
            out.println("<td>"+equipo.getNumeroOds()+"</td>");
            out.println("<td>"+equipo.getAvanceHoras()+".</td>");
            out.println("</tr>");
        }
    out.println("</table>");
    out.println("</div>");
}
//</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="Totales Reportes">

if(horas_trabajadores.size() > 0 || horas_equipos.size() > 0){
    out.println("<table class=\"tg\">");
        out.println("<tr>");
        out.println("<th class=\"tg-yw4l\">Número ODS</th>");
        out.println("<th class=\"tg-yw4l\">Avance Horas</th>");
        out.println("<th class=\"tg-yw4l\">Total Horas</th>");
        out.println("<th class=\"tg-yw4l\">Fecha Vencimiento</th>");
        out.println("</tr>");

        for(int i = 0; i<horas_trabajadores.size();i++){
    
            trabajador = horas_trabajadores.get(i);
            equipo = horas_equipos.get(i);
    
            out.println("<tr>");
            out.println("<td class=\"tg-6k2t\">"+trabajador.getNumeroOds() +"</td>");
            int total = trabajador.getAvanceHoras() + equipo.getAvanceHoras();
            out.println("<td class=\"tg-6k2t\">"+total+".</td>");
            out.println("<td class=\"tg-6k2t\">"+trabajador.getTotal_horas()+"</td>");
            out.println("<td class=\"tg-6k2t\">"+trabajador.getFecha_Termino_ODS()+".</td>");
            out.println("</tr>");
        }
        out.println("</table>");
}
//</editor-fold>
 
            out.println("<form action='Avance_obras_reporte.jsp'>");
            out.println("<input type='submit' >");
            out.println("</form>");
            request.setAttribute("trabajadores", horas_trabajadores);
            request.setAttribute("equipos", horas_equipos);
            
            
            
request.getRequestDispatcher("/WEB-INF/jspf/bottom.jspf").include(request,response); 
out.println("</div>");
out.println("</body>");
out.println("</html>");
            
           
            
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
