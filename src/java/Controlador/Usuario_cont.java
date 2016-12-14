/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thebe
 */
@WebServlet(name = "Usuario_cont", urlPatterns = {"/Usuario_cont"})
public class Usuario_cont extends HttpServlet {

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
        try {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("hola desde usuario cont");
            out.println("</body>");
        } finally {
            PrintWriter out = response.getWriter();
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
          response.setContentType("text/html;charset=UTF-8");
          try{
          HttpSession usuario = request.getSession();
        Usuario user = new Usuario(request.getParameter("usuario"),request.getParameter("contrasena"));
        boolean aceptado = this.logging(user);
        
            if(aceptado == true) {
              String var = user.getUsuario();
              request.setAttribute("error",var);
              request.getSession().setAttribute("error",var);
              this.getServletConfig().getServletContext().setAttribute("error", var);
              //response.sendRedirect("Home");
              request.getRequestDispatcher("/faces/header.jsp").forward(request, response);
               
            }
            else{
              // out.println("usuario rechazado");
              String var = "Usuario y/o Contraseña Incorrectos";
              usuario.setAttribute("error",var);
              //request.getSession().setAttribute("error",var);
              //this.getServletConfig().getServletContext().setAttribute("error", var);
              request.getServletContext().getRequestDispatcher("Logeo").forward(request, response);
               
            }
        }
        catch(Exception ex){
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>error: "+ex+"</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
        
    }

    public boolean logging(Usuario usuario){
        usuario = usuario.logeo(usuario);
        if(usuario != null) return true;
        else return false;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
