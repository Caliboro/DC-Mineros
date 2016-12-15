package Controlador;

import Modelo.Trabajador;
import Modelo.CarpetaDeArranque;
import Modelo.Contrato;
import Modelo.Licencia;
import Modelo.Examen;
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Obras_Servlet extends javax.servlet.http.HttpServlet {
   public java.util.Collection<CarpetaDeArranque> carpetaDeArranque;
   public java.util.Collection<Trabajador> trabajador;
   public java.util.Collection<Obras_Servlet> obras;
   
   protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
      //  res.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = res.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("hola desde usuario cont");
            out.println("</body>");
        } finally {
            PrintWriter out = res.getWriter();
            out.close();
        }
    }
   public void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {
       
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      
      String var1= req.getParameter("var1");
      String[] datos = var1.split("[?]");
      Contrato contra = new Contrato();
      Contrato contra2 = new Contrato();
      
      ArrayList <Contrato> trabajadores = new ArrayList <Contrato>();
      ArrayList <Contrato> contrato_equipos = new ArrayList <Contrato>();
      
      contrato_equipos = contra2.Actividad_Equipo(datos[0],datos[1],datos[2]);
      
      trabajadores = contra.Actividad_Trabajadores(datos[0],datos[1],datos[2]);
      
      
      req.setAttribute("equipos",contrato_equipos);
      req.setAttribute("trabajadores",trabajadores);
      req.getServletContext().getRequestDispatcher("/"+datos[3]).forward(req, res);
      
      
      out.close();
   }
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      
      res.setContentType("text/html;charset=UTF-8");
      HttpSession contratos_valor = req.getSession();

     
     ArrayList <Contrato> contrato = new ArrayList <Contrato>();
     Contrato contra = new Contrato();
     String desde1, hasta1,servlet;
     servlet = req.getParameter("servlet");
     
     desde1 = req.getParameter("desde");
     desde1 = formato_fecha(desde1);
     hasta1 = req.getParameter("hasta");
     hasta1 = formato_fecha(hasta1);
      
     contrato = contra.Contratos_disponibles(hasta1);
     
    
     contratos_valor.setAttribute("contratos",contrato); 
     req.getServletContext().getRequestDispatcher("/"+servlet).forward(req, res); 
   }
   
   public String formato_fecha(String fecha){
       try{
       String [] partes = fecha.split("-");
       fecha = partes[2]+"-"+partes[1]+"-"+partes[0];
       return fecha;
       }catch(Exception ex){
       return "error";
       }
   
   }
      
}
