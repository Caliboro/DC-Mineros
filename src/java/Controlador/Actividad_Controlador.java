/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Equipo;
import Modelo.Trabajador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thebe
 */
public class Actividad_Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Actividad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Actividad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String var1= request.getParameter("var1");
        String[] datos = var1.split("[?]");
        int valor = Integer.parseInt(datos[3]);
        System.out.println(valor);
        if(valor > 0){
            
            Trabajador trabajador = new Trabajador();
            ArrayList <Trabajador> trabajadores = new ArrayList <Trabajador>();
            trabajadores = trabajador.actividades(datos[0],datos[1],datos[2]);
            request.setAttribute("Actividad",trabajadores);
            request.getServletContext().getRequestDispatcher("/Obras_trabajadores").forward(request, response);
        }
        else{
        
            Equipo equipo = new Equipo();
            ArrayList <Equipo> equipos = new ArrayList <Equipo>();
            equipos = equipo.actividades(datos[0],datos[1],datos[2]);
            request.setAttribute("Actividad",equipos);
            request.getServletContext().getRequestDispatcher("/Obras_equipos").forward(request, response);

        } 
 /*   PrintWriter out = response.getWriter();
     
    out.println("<html>");
    out.println("<head>");
    out.println("<title>");
    out.println("</title>");
    out.println("<body>");
    out.println("<h1>"+datos[0]+datos[1]+datos[2]+"</h1>");
    out.println("<h1>"+equipos.size()+"</h1>");
    for(int i=0; i<equipos.size(); i++){
        
        equipo = equipos.get(i);
        out.println("<h1>"+equipo.getNombreEquipo()+"</h1>");
       // out.println("<h1>"+equipo.getActividad().getFecha_actividad()+"</h1>");
        
        }
    
    
    out.println("</body>");
    out.println("</head>");
    out.println("</html>"); */
      
        
        
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
