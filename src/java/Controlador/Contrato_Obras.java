/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Contrato;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thebe
 */
public class Contrato_Obras extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Contrato_Obras</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Contrato_Obras at " + request.getAttribute("desde") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
         HttpSession contratos_valor = request.getSession();
       // PrintWriter out = response.getWriter();
        
      
      String var1= request.getParameter("var1");
      String[] datos = var1.split("[?]");
      Contrato contra = new Contrato();
      contra.setIdContrato(datos[2]);
      
      ArrayList <Contrato> ODS = new ArrayList <Contrato>();
      ODS = contra.ODS_disponibles(contra);
      

      contratos_valor.setAttribute("ODS",ODS);
      request.getServletContext().getRequestDispatcher("/"+datos[3]).forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Contrato_Obras</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Contrato_Obras at " + request.getParameter("desde") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
