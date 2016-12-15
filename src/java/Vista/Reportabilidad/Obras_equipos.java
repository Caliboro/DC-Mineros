/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Reportabilidad;

import Modelo.Contrato;
import Modelo.Equipo;
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
@WebServlet(name = "Obras_equipos", urlPatterns = {"/Obras_equipos"})
public class Obras_equipos extends HttpServlet {

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
        
//<editor-fold defaultstate="collapsed" desc="Variables">
ArrayList <Contrato> contratos = null;
ArrayList <Contrato> ODS = null;
ArrayList <Equipo> actividades = null;
Contrato cont = new Contrato(), cont_ODS = new Contrato();
Equipo trabajador = new Equipo();
ArrayList <Equipo> equipo = new ArrayList <Equipo>();
//</editor-fold>
        
        
//<editor-fold defaultstate="collapsed" desc="Base HTML 1">
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
request.getRequestDispatcher("/faces/header.jsp").include(request, response);
//</editor-fold>
     
//<editor-fold defaultstate="collapsed" desc="Base HTML 2">
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            
out.println("<title>Actividades de Equipos</title>");
out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet Obras_equipos at " + request.getContextPath() + "</h1>");
//</editor-fold>
            
//<editor-fold defaultstate="collapsed" desc="Formulario Fechas">
out.println("<div id='contenedor_formulario'>");
out.println("<form action= Obras_Servlet method='post' />");
out.println("Ingrese Rango de Fechas");
out.println("<p>Desde: <input type='text' name='desde' />");
out.println("Hasta: <input type='text' name= 'hasta' /></p>");

out.println("<input type='text' name='servlet' value='Obras_equipos' placeholder='Obras_equipos' style='visibility:hidden'>");

out.println("<p><input type='submit' name='Ingresafecha'/></p>");
out.println("</form>");
out.println("</div>");
//</editor-fold>
            
//<editor-fold defaultstate="collapsed" desc="Despliegue Contratos">
contratos = (ArrayList <Contrato>)request.getSession().getAttribute("contratos");
int contador = 1;
for(int i= 0 ; i<contratos.size() ; i++ ){
    
    cont = contratos.get(i);
    String color;
    if( cont.getEstado_contrato().trim() == "Vigente") color = "#C8FE2E";
    if( cont.getEstado_contrato().trim() == "Vencido") color = "#B40404";
    if( cont.getEstado_contrato().trim() == "Por Vencer") color = "#DBA901";
    if( cont.getEstado_contrato().trim() == "En Tramitación") color = "#58ACFA";
    else color = "black";
    
    
    contador = contador+i;
    out.println("<a href='Contrato_Obras?var1="+cont.getFecha_inicio()+"?"+cont.getFecha_termino()+"?"+contador+"?Obras_equipos' action= get>");
    out.println("<div id='contenedor_contratos'  style='background-color:'"+color+"'>");
    out.println("<p id='contrato'>Contrato: "+cont.getNombre_contrato()+".</p>");
    out.println("<p id='contrato'>Estado: "+cont.getEstado_contrato()+".</p>");
    out.println("<p id='contrato'>Inicio Contrato: "+cont.getFecha_inicio()+".</p>");
    out.println("<p id='contrato'>Fin Contrato: "+cont.getFecha_termino()+".</p>");
    out.println("</div>");
    out.println("</a>");
}
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Despliegue ODS">
ODS = (ArrayList <Contrato>)request.getSession().getAttribute("ODS");

if(ODS.size() > 0){
    out.println("<h1> Órdenes de Servicio Disponibles</h1>");
        
        

    for(int j=0; j<ODS.size(); j++){
    
        cont_ODS = ODS.get(j);
        out.println("<a href='Actividad?var1="+cont.getFecha_inicio()+"?"+cont.getFecha_termino()+"?60?2' action= get>");
        out.println("<div>");
        out.println("<p>Número ODS: "+cont_ODS.getNumeroOds()+",");
        out.println("Total Horas Programadas: "+cont_ODS.getTotal_horas()+", ");
        out.println("Término ODS: "+cont_ODS.getFecha_Termino_ODS()+"</p>");
        out.println("</div>");
        out.println("</a>");
    }
}
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Despliegue Actividades">

equipo = (ArrayList <Equipo>)request.getAttribute("Actividad");

if(equipo.size() > 0){
    out.println("<table class=\"tg\">");
        
        out.println("<tr>");
            out.println("<th class=\"tg-yw4l\">Nombre Actividad</th>");
            out.println("<th class=\"tg-yw4l\">Avance en Horas</th>");
            out.println("<th class=\"tg-yw4l\">Fecha Realización</th>");
            out.println("<th class=\"tg-yw4l\">Nombre Equipo</th>");
            out.println("<th class=\"tg-yw4l\">Num. Serie</th>");
        out.println("</tr>");

        for(int i=0; i<equipo.size();i++){
            
            trabajador = equipo.get(i);
            
            out.println("<tr>");
                out.println("<th>"+trabajador.getActividad().getNombre_actividad()+"</th>");
                out.println("<th>"+trabajador.getActividad().getAvance_horas_trab()+"</th>");
                out.println("<th>"+trabajador.getActividad().getFecha_actividad()+"</th>");
                out.println("<th>"+trabajador.getNombreEquipo()+"</th>");
                out.println("<th>"+trabajador.getPatente()+"</th>");
            out.println("</tr>");
        }
        out.println("</table>");
}


for(int i=0; i<equipo.size();i++){
    
    
}
//</editor-fold>
            request.getRequestDispatcher("/WEB-INF/jspf/bottom.jspf").include(request,response);
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
