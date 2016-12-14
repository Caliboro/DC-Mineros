package Modelo;


import java.util.*;

public class Licencia {

   private int idLicencia;
   private String tipoLicencia;
   private Date fechaEmision;
   private Date fechaVencimiento;
   private Boolean estadoLicencia;
   
   public int getIdLicencia() {
      return idLicencia;
   }
   public void setIdLicencia(int newIdLicencia) {
      idLicencia = newIdLicencia;
   }
   public String getTipoLicencia() {
      return tipoLicencia;
   }
   public void setTipoLicencia(String newTipoLicencia) {
      tipoLicencia = newTipoLicencia;
   }
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
   public Boolean getEstadoLicencia() {
      return estadoLicencia;
   }
   public void setEstadoLicencia(Boolean newEstadoLicencia) {
      estadoLicencia = newEstadoLicencia;
   }
   
   public Boolean validarLicencia(){
   return true;
   }
   public Boolean denegarLicencia(){
   return true;
   }
   public Boolean controlarLicencias(){
   return true;
   }

}
