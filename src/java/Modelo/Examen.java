package Modelo;


import java.util.*;

public class Examen {

   private Integer idExamen;
   private Date fechaEmision;
   private Date fechaVencimiento;
   private String detalles;
   private String nombreExamen;
   private String centroMedico;
   
   public Date getFechaEmision() {
      return fechaEmision;
   }
   
   public void setFechaEmision(Date newFechaEmision) {
      fechaEmision = newFechaEmision;
   }
   
   public Date getFechaVencimiento() {
      return fechaVencimiento;
   }
   
   public void setFechaVencimiento(Date newFechaVencimiento) {
      fechaVencimiento = newFechaVencimiento;
   }

   public String getDetalles() {
      return detalles;
   }
   
   public void setDetalles(String newDetalles) {
      detalles = newDetalles;
   }
   
   public String getNombreExamen() {
      return nombreExamen;
   }
   
   public void setNombreExamen(String newNombreExamen) {
      nombreExamen = newNombreExamen;
   }
   
   public String getCentroMedico() {
      return centroMedico;
   }
   
   public void setCentroMedico(String newCentroMedico) {
      centroMedico = newCentroMedico;
   }
   
   public Boolean validarExamen(){
   return true;
   }
   public Boolean ingresarExamen(){
   return true;
   }
   public Boolean controlarExamen(){
   return true;
   }
   

}
