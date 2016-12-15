
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Contrato"%>
<%@page import="Modelo.Trabajador"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.nio.file.Paths"%>
<%@ page import="java.nio.file.Path"%>
<%@ page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@ page contentType="application/pdf"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="net.sf.jasperreports.view.JasperViewer"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="javax.servlet.ServletResponse"%>

        <%
       
        try{
        
        
       // trabajadores = (ArrayList<Contrato>)request.getAttribute("trabajadores");
       // trabajadores = (ArrayList<Contrato>)request.getAttribute("equipos");
   
       //diego_pizarro.rojo@hotmail.com dpizarro.rojo@gmail.com
        
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/dc_mineros_1.1","root","");
        
        //int contrato = Integer.parseInt(request.getParameter("contrato"));
        //String inicio = request.getParameter("inicio");
        //String fin = request.getParameter("fin");
        
        int contrato = 1;
        String inicio = "2012-01-01";
        String fin = "2017-01-01";
        
        String archivo = session.getServletContext().getRealPath("/reportes/avance_obras.jrxml");
        InputStream input = new FileInputStream(new File(archivo));
        
        
        Map<String,Object> parameter = new HashMap<String,Object>();
        parameter.put("ID_CONTRATO1", 1);
        parameter.put("fecha_inicio1", "2012-01-01");
        parameter.put("fecha_termino1", "2017-01-01");
        parameter.put("id_contrato2", 1);
        parameter.put("fecha_inicio2", "2012-01-01");
        parameter.put("fecha_termino2", "2017-01-01");
        
        
        
        JasperReport jasperreport = JasperCompileManager.compileReport(input);
        JasperPrint jasperprint = JasperFillManager.fillReport(jasperreport,parameter,conn);
        
        JasperExportManager.exportReportToPdfStream(jasperprint,response.getOutputStream());
        
        response.getOutputStream().flush();
        response.getOutputStream().close();
        
        }catch(Exception ex){
            
            System.out.println(ex);
        
        }
        %>
