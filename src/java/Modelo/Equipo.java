package Modelo;


import java.sql.ResultSet;
import java.util.*;
import Modelo.Base_de_Datos;
import java.io.IOException;

public class Equipo extends Base_de_Datos {

   private int idEquipo;
   private String nombreEquipo;
   private String patente;
   private Date fechaUtilizacion;
   private String areaUtilizacion;
   private Actividad actividad;

    public Equipo() {
      //  conectar();
    }
   

   //<editor-fold defaultstate="collapsed" desc="Getters and setters">
   public Actividad getActividad() {
       return actividad;
   }
   
   public void setActividad(Actividad actividad) {
       this.actividad = actividad;
   }
   
   public int getIdEquipo() {
       return idEquipo;
   }
   public void setIdEquipo(int newIdEquipo) {
       idEquipo = newIdEquipo;
   }
   public String getNombreEquipo() {
       return nombreEquipo;
   }
   public void setNombreEquipo(String newNombreEquipo) {
       nombreEquipo = newNombreEquipo;
   }
   public String getPatente() {
       return patente;
   }
   public void setPatente(String newPatente) {
       patente = newPatente;
   }
   public Date getFechaUtilizacion() {
       return fechaUtilizacion;
   }
   public void setFechaUtilizacion(Date newFechaUtilizacion) {
       fechaUtilizacion = newFechaUtilizacion;
   }
   public String getAreaUtilizacion() {
       return areaUtilizacion;
   }
   public void setAreaUtilizacion(String newAreaUtilizacion) {
       areaUtilizacion = newAreaUtilizacion;
   }
//</editor-fold>

   public ArrayList actividades(String fecha_inicio, String Fecha_termino, String numero_ods){
    
    ArrayList <Equipo> actividades = new ArrayList <Equipo>();
    
    try{
        ResultSet rst;
        getStmt();
        Equipo cont;
        Actividad actividad = new Actividad();
        rst = stmt.executeQuery("SELECT RE.NOMBRE_ACTIVIDAD, RE.AVANCE_HORAS, RE.FECHA_ACTIVIDAD, EQ.NOMBRE_EQUIPO, EQ.PATENTE FROM ((registro_equipos AS RE INNER JOIN equipo AS EQ ON RE.ID_EQUIPO = EQ.ID_EQUIPO) INNER JOIN ODS ON ODS.ID_ODS = RE.ID_ODS) WHERE RE.ID_ODS = 60");
            while(rst.next()){
                cont = new Equipo();
                actividad = new Actividad();
                actividad.setNombre_actividad((rst.getString(1)));
                actividad.setAvance_horas_trab(Float.parseFloat(rst.getString(2)));
                actividad.setFecha_actividad(rst.getString(3));
                cont.setNombreEquipo(rst.getString(4));
                cont.setPatente(rst.getString(5));
                cont.setActividad(actividad);
                actividades.add(cont);
            }
            return actividades;
       
       }
       catch(Exception ex){
       System.out.println(ex);
       
       return null;
        }
}

}
