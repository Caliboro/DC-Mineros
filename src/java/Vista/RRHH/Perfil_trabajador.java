/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.RRHH;

import Controlador.Trabajador_controlador;
import Modelo.Trabajador;
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
@WebServlet(name = "Perfil_trabajador", urlPatterns = {"/Perfil_trabajador"})
public class Perfil_trabajador extends HttpServlet {

    static String nombre = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //<editor-fold defaultstate="collapsed" desc="Base HTML">
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("/faces/header.jsp").include(request, response);
        
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Perfil_trabajador</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Perfil_trabajador at " + request.getContextPath() + "</h1>");
//</editor-fold>
            
            ArrayList <Trabajador> trabajadores = new ArrayList <Trabajador>();
            Trabajador_controlador TC = new Trabajador_controlador();
            trabajadores = TC.cargar_Trabajadores();
            Trabajador trabajador = new Trabajador();
            Trabajador trabajador2 = new Trabajador();
            

            out.println("<h1>Perfil del Trabajador</h1>");
            out.println("<h2>");
            if(nombre == null) out.println("Seleccione un Trabajador</h2>"); 
            else out.println(nombre+"</h2>"); 
            
            out.println("<table>");
            
                out.println("<tr>");
                
                    out.println("<td>Nombre Trabajador</td>");
                    out.println("<td>Apellido Paterno</td>");
                    out.println("<td>Apellido Materno</td>");
                    out.println("<td>Correo Electrónico</td>");
                    out.println("<td>Rut</td>");
                    out.println("<td>Domicilio</td>");
                    out.println("<td></td>");
                
                out.println("</tr>");
                
                for(int i=0; i<trabajadores.size();i++){
                    
                        trabajador = trabajadores.get(i);
                        String rut = trabajador.getRutTrabajador();
                        
                out.println("<tr>");        
                        out.println("<td><a href='Trabajador_controlador?var="+rut+"?Perfil_trabajador' >"+trabajador.getNombre()+"</a></td>");
                        out.println("<td>"+trabajador.getApellidoPaterno()+"</td>");
                        out.println("<td>"+trabajador.getApellidoMaterno()+"</td>");
                        out.println("<td>"+trabajador.geteMail()+"</td>");
                        out.println("<td>"+trabajador.getRutTrabajador()+"</td>");
                        out.println("<td>"+trabajador.getDomicilio()+"</td>");
                out.println("</tr>");
                
                    }
            out.println("</table>");
            
            out.println("<ul>");
                    trabajador2 = (Trabajador)request.getAttribute("perfil");
                    out.println("<li type='disc'>Turno:"+trabajador2.getTurno()+"</li>");
                    out.println("<li type='disc'>Jornada"+trabajador2.getJornada()+"</li>");
                    out.println("<li type='disc'>Salario"+trabajador2.getSalario()+"</li>");
                    out.println("<li type='disc'>Rut"+trabajador2.getRutTrabajador()+"</li>");
                    out.println("<li type='disc'>Fecha Nacimiento: "+trabajador2.getFechaNacimiento()+"</li>");
                    out.println("<li type='disc'>Sexo"+trabajador2.getSexo()+"</li>");
                    out.println("<li type='disc'>Nacionalidad"+trabajador2.getNacionalidad()+"</li>");
                    out.println("<li type='disc'>Domicilio"+trabajador2.getDomicilio()+"</li>");
                    out.println("<li type='disc'>Celular"+trabajador2.getCelular()+"</li>");
                    out.println("<li type='disc'>Correo Electrónico"+trabajador2.geteMail()+"</li>");
                    out.println("<li type='disc'>Comuna"+trabajador2.getComuna()+"</li>");
                    out.println("<li type='disc'>Provincia"+trabajador2.getProvincia()+"</li>");
                    out.println("<li type='disc'>Region"+trabajador2.getRegion()+"</li>");
                    out.println("<li type='disc'>Cargo"+trabajador2.getCargo().getNombre_cargo()+"</li>");
            
            out.println("</ul>");
            
            
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
