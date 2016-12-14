/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
/**
 *
 * @author thebe
 */
public class Base_de_Datos {
    
    protected Connection con;
    protected Statement stmt;
    private String servidor= "localhost";
    private String puerto="3306";
    private String base_de_datos="dc_mineros_1.1";
    private String url= "jdbc:mysql://localhost:3306/"+base_de_datos;
    private String usuario="root";
    private String contrasena="";
    private String errString;

    public Base_de_Datos() {
    }
    
    public Connection conectar (){
    con= null;
    try{
        Class.forName("org.gjt.mm.mysql.Driver");
        con = DriverManager.getConnection(url, usuario, contrasena);
        stmt=con.createStatement();
        System.out.println("Conectado");
    }
    catch(Exception e){
        errString= "No se pudo conectar";
        System.out.println(errString);
        return null;
    }
    return con;
    }
    public Statement getStmt(){
    conectar();
    return stmt;
    }
}
