<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection con = null;
            
            try{
            
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/dc_mineros_1.1","root","");
                out.print("conexion en linea");
                
                
            }catch(Exception ex){
            out.print("Error al conectar:"+ex.getMessage());
            }
            
            
            %> 
    </body>
</html>

