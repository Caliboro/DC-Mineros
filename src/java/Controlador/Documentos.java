package Controlador;

import Modelo.Trabajador;
import Modelo.CarpetaDeArranque;
import Modelo.Documento;
import Modelo.Licencia;
import Modelo.Examen;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Documentos extends javax.servlet.http.HttpServlet {

   public Documentos documentos;
   public CarpetaDeArranque[] CarpetaDeArranque;
   public Examen Examen;
   public Licencia[] licencia;
   public Trabajador[] trabajador;
   
   public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException {
      super.init(config);
   }
   public void destroy() {
      super.destroy();  
   }
   
   public void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {

      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
   
      out.println("<HTML>");   
      out.println("<HEAD>");   
      out.println("<TITLE>Add the title here</TITLE>");   
      out.println("</HEAD>");   
      out.println("<BODY>");   
      out.println("HTTP servlet: doGet()");
      out.println("</BODY>");   
      out.println("</HTML>");   
      
      out.close();
   }
   
   public void doPut(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {

      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
   
      out.println("<HTML>");   
      out.println("<HEAD>");   
      out.println("<TITLE>Add the title here</TITLE>");   
      out.println("</HEAD>");   
      out.println("<BODY>");   
      out.println("HTTP servlet: doPut()");
      out.println("</BODY>");   
      out.println("</HTML>");   
      
      out.close();
   }
   
   public void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {

      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
      
      String rut = req.getParameter("rut");
      if(req.getParameter("rut").toString().length() <= 0){
      rut = "Ingrese Rut a Buscar";
      req.setAttribute("error",rut);
      req.getServletContext().getRequestDispatcher("/Documentos_trabajador").forward(req, res);
      }
      boolean ver = this.verificador(rut);
      if(ver == false){
      rut = "Rut Incorrecto";
      req.setAttribute("error",rut);
      req.getServletContext().getRequestDispatcher("/Documentos_trabajador").forward(req, res);
      } 
      else{
      ArrayList <Trabajador> trabajadores = new ArrayList <Trabajador>();
      Trabajador trab = new Trabajador();
      
      trabajadores = trab.desplegar_documentos(rut);
      
      req.setAttribute("error",trabajadores);
      req.getServletContext().getRequestDispatcher("/Documentos_trabajador").forward(req, res);
      
      
      
      
      
      }
       
      
      
      
      
      out.close();
   }

   public boolean verificador(String rut){
        
       boolean validacion = false; 
       try{
        
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutaux = Integer.parseInt(rut.substring(0,rut.length()-1));
            
            char dv = rut.charAt(rut.length()-1);
            
            int m=0,s=1;
            for(; rutaux !=0; rutaux /=10){
            
                s= (s+rutaux % 10 *(9-m++ % 6)) % 11;
            
            }
            if(dv == (char)(s!=0 ? s+ 47 : 75)){validacion = true;}
        }catch(java.lang.NumberFormatException e){
        }catch(Exception ex){
        }
       
       return validacion;
   }
   
}