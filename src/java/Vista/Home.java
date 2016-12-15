/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thebe
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
        request.getRequestDispatcher("/faces/header.jsp").include(request, response);
        
        PrintWriter out = response.getWriter();
        try { 
            out.println("<HTML>");
            out.println("<HEAD>");
            request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            out.println("<TITLE>HOLA DESDE POST</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("HOLA DESDE POST");
            // request.getRequestDispatcher("/WEB-INF/jspf/Estilo_body.jspf").include(request, response);
            request.getRequestDispatcher("/WEB-INF/jspf/bottom.jspf").include(request,response);
            out.println("</BODY>");
            out.println("</HTML>");
            
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
         out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>HOLA DESDE POST</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("HOLA DESDE POST1");
            out.println("</BODY>");
            out.println("</HTML>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/faces/header.jsp").include(request, response);
        PrintWriter out = response.getWriter();   
        try{
             out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>HOLA DESDE POST</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("HOLA DESDE POST2");
            out.println("</BODY>");
            out.println("</HTML>");
            
            }
        catch(Exception ex){
            System.out.println("error");
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
