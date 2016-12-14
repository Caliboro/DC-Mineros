
package Controlador;

import Modelo.Contrato;
import Modelo.Trabajador;
import Modelo.cargo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Trabajador_controlador", urlPatterns = {"/Trabajador_controlador"})
public class Trabajador_controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Trabajador_controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Trabajador_controlador at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        try {
            
            String rut= request.getParameter("var");
            String [] valores = rut.split("[?]");
            Trabajador trabajador = new Trabajador();
            trabajador = trabajador.desplegar_trabajador(valores[0]);
            
            request.setAttribute("perfil", trabajador);
            request.getServletContext().getRequestDispatcher("/"+valores[1]).forward(request, response);
           
           
            
        } finally {
            out.close();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //<editor-fold defaultstate="collapsed" desc="Variables">
        String var=request.getParameter("nombre");
        String[] datos = var.split("[ ]");
        cargo Cargo = new cargo();
        Contrato contrato= new Contrato();
        int jornada=0, salario=0;
        boolean sexo = false;
//</editor-fold>
               
          try{
            //<editor-fold defaultstate="collapsed" desc="validadores">
              String mensaje = "";
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("jornada").toString().length() <= 0){
                  mensaje = mensaje + "Jornada";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("sexo") == null && request.getParameter("masculino") == null){
                  mensaje = mensaje + "?Sexo";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("turno").toString().length() <= 0){
                  mensaje = mensaje + "?Turno";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("rut").toString().length() <= 0){
                  mensaje = mensaje + "?Rut";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("salario").toString().length() <= 0){
                  mensaje = mensaje + "?Salario";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("nombre").toString().length() <= 0){
                  mensaje = mensaje + "?Nombre";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("fecha_nacimiento").toString().length() <= 0){
                  mensaje = mensaje + "?Fecha de Nacimiento";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("nacionalidad").toString().length() <= 0){
                  mensaje = mensaje + "?Nacionalidad";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("domicilio").toString().length() <= 0){
                  mensaje = mensaje + "?Domicilio";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("provincia") == null){
                  mensaje = mensaje + "?Provincia";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("cargo").toString().length() <= 0){
                  mensaje = mensaje + "?Cargo";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("contrato_asociado") == null){
                  mensaje = mensaje + "?Contrato";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("celular").toString().length() <= 0){
                  mensaje = mensaje + "?Celular";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("email").toString().length() <= 0){
                  mensaje = mensaje + "?Correo Electrónico";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("region") == null){
                  mensaje = mensaje + "?Región";
              }
              System.out.println("HOLAAAAA"+mensaje);
              if(request.getParameter("comuna") == null){
                  mensaje = mensaje + "?Comuna";
              }
             
               var=request.getParameter("nombre");
              datos = var.split(" ");
              if(datos.length < 3 || datos.length > 3) mensaje = mensaje + "Nombre no Válido";
              if(validarRut(request.getParameter("rut")) == false) mensaje = mensaje + "?Rut no Válido";
              if(formato_fecha(request.getParameter("fecha_nacimiento")) == null) mensaje = mensaje + "?Fecha no Válida";
              try{
                  salario = Integer.parseInt(request.getParameter("salario"));
              }catch(Exception ex){mensaje = mensaje + "?Salario no Válido";}
              try{
                  jornada = Integer.parseInt(request.getParameter("jornada"));
              }catch(Exception ex){mensaje = mensaje + "?Jornada no Válida";}
              //validar sexo
              if(request.getParameter("celular").length() != 8) mensaje = mensaje + "?Celular no Válido";
              if(mensaje.length() > 0){
                  System.out.println("HOLAAAAA"+mensaje);
                  request.setAttribute("error",mensaje);
                  request.getServletContext().getRequestDispatcher("/Contratacion").forward(request, response);
              }else{
             
//</editor-fold>
           
            //<editor-fold defaultstate="collapsed" desc="Formato Datos">
            String rut = request.getParameter("rut");
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            String fecha_nac = request.getParameter("fecha_nacimiento");
            fecha_nac = formato_fecha(fecha_nac);
            String celular ="+569" + request.getParameter("celular");
            
            //</editor-fold>
            
            Cargo.setNombre_cargo(request.getParameter("cargo"));
            
            Trabajador trabajador = new Trabajador(request.getParameter("turno"),jornada, salario,rut,datos[0], datos[1], datos[2], fecha_nac, sexo, request.getParameter("nacionalidad"),request.getParameter("domicilio"), celular,request.getParameter("email"),request.getParameter("comuna"),request.getParameter("provincia"), request.getParameter("region"),Cargo, contrato);
            
            mensaje = trabajador.ingresar_trabajadores(trabajador);
            request.setAttribute("error",mensaje);
            request.getServletContext().getRequestDispatcher("/Contratacion").forward(request, response);
              }
            
            
        }catch(Exception ex){
            System.out.println("ERROR FATAL");        
        }   
    }

    public boolean validarRut(String rut){
    
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
    public String formato_fecha(String fecha){
       try{
       String [] partes = fecha.split("-");
       fecha = partes[2]+"-"+partes[1]+"-"+partes[0];
       return fecha;
       }catch(Exception ex){
       return null;
       }
   
   }
    public ArrayList cargar_region (String tipo){
    ArrayList regiones = new ArrayList();
    Trabajador trab = new Trabajador();
        
        regiones = trab.cargar_region(regiones,tipo);
    
        return regiones;
    }
    public ArrayList cargar_contrato(){
    ArrayList contratos = new ArrayList();
    Trabajador trab = new Trabajador();
        
        contratos = trab.cargar_contratos(contratos);
    
        return contratos;
    
    }
    public ArrayList cargar_Trabajadores(){
    
        ArrayList <Trabajador> trabajadores = new ArrayList <Trabajador>();
        
        Trabajador trab = new Trabajador();
        
        trabajadores = trab.cargar_trabajadores();
        
        return trabajadores;
        
    }
    
}  

    

