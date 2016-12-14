
package Modelo;
import Modelo.Base_de_Datos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Usuario extends Base_de_Datos {
    
    private String usuario;
    private String contrasena;
    
    
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        conectar();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   /* public ResultSet getRst() {
        return rst;
    }

    public void setRst(ResultSet rst) {
        this.rst = rst;
    } */
    
    

    

    
    public Usuario logeo(Usuario usuario){
        try{
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("select * from usuario where NOMBRE_USUARIO = '"+usuario.getUsuario()+"' and CONTRASENA_USUARIO = '"+usuario.getContrasena()+"'  ");
        if(rst.next()) return usuario;
        else return null;
        }
        catch(Exception ex){
        System.out.println(""+ex+"");
        return null;
        }
    }
}
