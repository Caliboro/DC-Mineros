package Vista.Reportabilidad;

import Modelo.Actividad;
import Modelo.Contrato;
import Modelo.Trabajador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Obras_trabajadores extends HttpServlet {

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
        
        ArrayList <Contrato> contratos = null;
        ArrayList <Contrato> ODS = null;
        ArrayList <Trabajador> actividades = null;
        Contrato cont = new Contrato(), cont_ODS = new Contrato();
        Trabajador trabajador = new Trabajador();
        ArrayList <Trabajador> trabajadores = new ArrayList <Trabajador>();
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            
            //<editor-fold defaultstate="collapsed" desc="base html">
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            
out.println("<title>Servlet Obras_trabajadores</title>");
out.println("</head>");
out.println("<body>");

out.println("<h1>Servlet Obras_trabajadores at " + request.getContextPath() + "</h1>");
//</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Formulario Fechas">
            out.println("<div id='contenedor_formulario'>");
            out.println("<form action= Obras_Servlet method='post' />");
            out.println("Ingrese Rango de Fechas");
            out.println("<p>Desde: <input type='text' name='desde' />");
            out.println("Hasta: <input type='text' name= 'hasta' /></p>");
            
            out.println("<input type='text' name='servlet' value='Obras_trabajadores' placeholder='Obras_trabajadores' style='visibility:hidden'>");
            
            out.println("<p><input type='submit' name='Ingresafecha'/></p>");
            out.println("</form>");
            out.println("</div>");
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Despliegue contratos">
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
    out.println("<a href='Contrato_Obras?var1="+cont.getFecha_inicio()+"?"+cont.getFecha_termino()+"?"+contador+"?Obras_trabajadores' action= get>");
    out.println("<div id='contenedor_contratos'  style='background-color:'"+color+"'>");
    out.println("<p id='contrato'>Contrato: "+cont.getNombre_contrato()+".</p>");
    out.println("<p id='contrato'>Estado: "+cont.getEstado_contrato()+".</p>");
    out.println("<p id='contrato'>Inicio Contrato: "+cont.getFecha_inicio()+".</p>");
    out.println("<p id='contrato'>Fin Contrato: "+cont.getFecha_termino()+".</p>");
    out.println("</div>");
    out.println("</a>");
    
    ODS = (ArrayList <Contrato>)request.getSession().getAttribute("ODS");
}
//<editor-fold defaultstate="collapsed" desc="Despliegue ODS">
for(int j=0; j<ODS.size(); j++){
    
    cont_ODS = ODS.get(j);
    out.println("<a href='Actividad?var1="+cont.getFecha_inicio()+"?"+cont.getFecha_termino()+"?60?1' action= get>");
    //+cont_ODS.getNumeroOds()+
    out.println("<div id='contenedor_ods'>");
    out.println("<p id='ODS'>Número ODS: "+cont_ODS.getNumeroOds()+".</p>");
    out.println("<p id='ODS'>Total de Horas: "+cont_ODS.getTotal_horas()+".</p>");
    out.println("<p id='ODS'>Fecha Término ODS: "+cont_ODS.getFecha_Termino_ODS()+".</p>");
    out.println("</div>");
    out.println("</a>");
}
//</editor-fold>
    
    
    trabajadores = (ArrayList <Trabajador>)request.getAttribute("Actividad");
    
    if(trabajadores.size() > 0){
        out.println("<table class=\"tg\">");
        
            out.println("<tr>");
                out.println("<th class=\"tg-yw4l\">Nombre Actividad</th>");
                out.println("<th class=\"tg-yw4l\">Avance en Horas</th>");
                out.println("<th class=\"tg-yw4l\">Fecha Realización</th>");
                out.println("<th class=\"tg-yw4l\">Nombre Equipo</th>");
                out.println("<th class=\"tg-yw4l\">Num. Serie</th>");
            out.println("</tr>");
    
        for(int i=0; i<trabajadores.size();i++){
    
            trabajador = trabajadores.get(i);
            out.println("<tr>");
            out.println("<th>"+trabajador.getActividad().getNombre_actividad()+"</th>");
            out.println("<th>"+trabajador.getActividad().getAvance_horas_trab()+"</th>");
            out.println("<th>"+trabajador.getActividad().getFecha_actividad()+"</th>");
            out.println("<th>"+trabajador.getNombre()+"</th>");
            out.println("</tr>");
        }
    
        out.println("</table>");
        
    }
    
    
    
    


//</editor-fold>

            request.getRequestDispatcher("/WEB-INF/jspf/bottom.jspf").include(request,response);
            out.println("</body>");
            out.println("</html>");
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
