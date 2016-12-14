package Modelo;

import java.util.*;
import Modelo.Base_de_Datos;
import java.sql.ResultSet;

public class Contrato extends Base_de_Datos {

   private String idContrato;
   private int numeroOds;
   private String actividad;
   private Date fechaActividad;
   private Boolean tipoActividad;
   private Integer avanceHoras;
   private String nombre_contrato;
   private String fecha_inicio;
   private String fecha_termino;
   private String estado_contrato;
   private int total_horas;
   private String Fecha_Termino_ODS;
   
   public java.util.Collection<Equipo> Trabaja;
   public java.util.Collection<CarpetaDeArranque> EsContenida;
   
//Constructores
    public Contrato(String idContrato, int numeroOds, String actividad, Date fechaActividad, Boolean tipoActividad, Integer avanceHoras, String nombre_contrato, String fecha_inicio, String fecha_termino, String estado_contrato) {
        this.idContrato = idContrato;
        this.numeroOds = numeroOds;
        this.actividad = actividad;
        this.fechaActividad = fechaActividad;
        this.tipoActividad = tipoActividad;
        this.avanceHoras = avanceHoras;
        this.nombre_contrato = nombre_contrato;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.estado_contrato = estado_contrato;
        conectar();
    }
    public Contrato(String fecha_inicio, String fecha_termino, String id_contrato) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.idContrato = id_contrato;
    }
    public Contrato() {
       // conectar();
    }

    public int getTotal_horas() {
        return total_horas;
    }
    public void setTotal_horas(int total_horas) {
        this.total_horas = total_horas;
    }
    public String getFecha_Termino_ODS() {
        return Fecha_Termino_ODS;
    }
    public void setFecha_Termino_ODS(String Fecha_Termino_ODS) {
        this.Fecha_Termino_ODS = Fecha_Termino_ODS;
    }
   public String getEstado_contrato() {
        return estado_contrato;
    }
   public void setEstado_contrato(String estado_contrato) {
        this.estado_contrato = estado_contrato;
    }
   public String getFecha_inicio() {
        return fecha_inicio;
    }
   public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
   public String getFecha_termino() {
        return fecha_termino;
    }
   public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }
   public String getNombre_contrato() {
        return nombre_contrato;
    }
   public void setNombre_contrato(String nombre_contrato) {
        this.nombre_contrato = nombre_contrato;
    }
   public String getIdContrato() {
        return idContrato;
    }
   public int getNumeroOds() {
      return numeroOds;
   }
   public void setNumeroOds(int newNumeroOds) {
      numeroOds = newNumeroOds;
   }
   public String getActividad() {
      return actividad;
   }
   public void setActividad(String newActividad) {
      actividad = newActividad;
   }
   public Date getFechaActividad() {
      return fechaActividad;
   }
   public void setFechaActividad(Date newFechaActividad) {
      fechaActividad = newFechaActividad;
   }
   public Boolean getTipoActividad() {
      return tipoActividad;
   }
   public void setTipoActividad(Boolean newTipoActividad) {
      tipoActividad = newTipoActividad;
   }
   public Integer getAvanceHoras() {
      return avanceHoras;
   }
   public void setAvanceHoras(Integer newAvanceHoras) {
      avanceHoras = newAvanceHoras;
   }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }
   
   
   
   //Métodos Relaciones Trabajador
   public java.util.Collection<Equipo> getTrabaja() {
      if (Trabaja == null)
         Trabaja = new java.util.HashSet<Equipo>();
      return Trabaja;
   }
   public java.util.Iterator getIteratorTrabaja() {
      if (Trabaja == null)
         Trabaja = new java.util.HashSet<Equipo>();
      return Trabaja.iterator();
   }
   public void setTrabaja(java.util.Collection<Equipo> newTrabaja) {
      removeAllTrabaja();
      for (java.util.Iterator iter = newTrabaja.iterator(); iter.hasNext();)
         addTrabaja((Equipo)iter.next());
   }
   public void addTrabaja(Equipo newEquipo) {
      if (newEquipo == null)
         return;
      if (this.Trabaja == null)
         this.Trabaja = new java.util.HashSet<Equipo>();
      if (!this.Trabaja.contains(newEquipo))
         this.Trabaja.add(newEquipo);
   }
   public void removeTrabaja(Equipo oldEquipo) {
      if (oldEquipo == null)
         return;
      if (this.Trabaja != null)
         if (this.Trabaja.contains(oldEquipo))
            this.Trabaja.remove(oldEquipo);
   }
   public void removeAllTrabaja() {
      if (Trabaja != null)
         Trabaja.clear();
   }
   //Métodos relacion carpeta de arranque
   public java.util.Collection<CarpetaDeArranque> getEsContrato(){
      if (EsContenida == null)
         EsContenida = new java.util.HashSet<CarpetaDeArranque>();
      return EsContenida;
   }
   public java.util.Iterator getIteratorEsContenida() {
      if (EsContenida == null)
         EsContenida = new java.util.HashSet<CarpetaDeArranque>();
      return EsContenida.iterator();
   }
   public void setEsContenida(java.util.Collection<CarpetaDeArranque> newEsContenida) {
      removeAllEsContenida();
      for (java.util.Iterator iter = newEsContenida.iterator(); iter.hasNext();)
         addEsContenida((CarpetaDeArranque)iter.next());
   }
   public void addEsContenida(CarpetaDeArranque newCarpetaDeArranque) {
      if (newCarpetaDeArranque == null)
         return;
      if (this.EsContenida == null)
         this.EsContenida = new java.util.HashSet<CarpetaDeArranque>();
      if (!this.EsContenida.contains(newCarpetaDeArranque))
         this.EsContenida.add(newCarpetaDeArranque);
   }
   public void removeEsContenida(CarpetaDeArranque oldCarpetaDeArranque) {
      if (oldCarpetaDeArranque == null)
         return;
      if (this.EsContenida != null)
         if (this.EsContenida.contains(oldCarpetaDeArranque))
            this.EsContenida.remove(oldCarpetaDeArranque);
   }
   public void removeAllEsContenida() {
      if (EsContenida != null)
         EsContenida.clear();
   }
   
   public ArrayList <Contrato> Contratos_disponibles(String desde){
    ArrayList <Contrato> contrato = new ArrayList <Contrato>();
    Contrato contra = new Contrato();
    
    //<editor-fold defaultstate="collapsed" desc="try">
    try{
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("SELECT * FROM CONTRATO WHERE FECHA_TERMINO_CONTRATO <= "+desde+" or FECHA_INICIO_CONTRATO >="+desde+"");
        if(rst.wasNull()) return null;
        else {
            while(rst.next()){
                contra = new Contrato();
                contra.setNombre_contrato(rst.getString("NOMBRE_CONTRATO"));
                contra.setFecha_inicio(rst.getString("FECHA_INICIO_CONTRATO"));
                contra.setFecha_termino(rst.getString("FECHA_TERMINO_CONTRATO"));
                contra.setEstado_contrato(rst.getString("ESTADO_CONTRATO"));
                contra.setIdContrato(rst.getString("ID_CONTRATO"));
                contrato.add(contra);
                
                
            }
            return contrato;
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="catch">
    catch(Exception ex){
        System.out.println(ex);
        return null;
    }
//</editor-fold>
   }
   public ArrayList <Contrato> ODS_disponibles(Contrato contratos){
        
    ArrayList <Contrato> contrato = new ArrayList <Contrato>();
    Contrato contra = new Contrato();
   
    try{
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("SELECT * FROM ODS WHERE ID_CONTRATO ="+contratos.getIdContrato());
        if(rst.wasNull()) return null;
        else {
            while(rst.next()){
                contra = new Contrato();
                contra.setIdContrato(rst.getString("ID_CONTRATO"));
                contra.setNumeroOds(Integer.parseInt( rst.getString("ID_ODS")));
                contra.setTotal_horas(Integer.parseInt(rst.getString("TOTAL_HORAS")));
                contra.setFecha_Termino_ODS(rst.getString("FECHA_TERMINO_ODS"));
                contrato.add(contra);   
            }
            return contrato;
        }
    }catch(Exception ex){
    System.out.println(ex);
    }
        
        return contrato; 
   }
   
   public ArrayList <Contrato> Actividad_Trabajadores (String fechai, String fechaf, String id){
   
       ArrayList <Contrato> Actividades = new ArrayList <Contrato>();
       
       try{
        ResultSet rst;
        getStmt();
        Contrato cont;
        rst = stmt.executeQuery("SELECT ods.ID_ODS AS 'Folio ODS', count(A.AVANCE_HORAS_TRAB) AS 'Horas Utilizadas', ods.Total_Horas, ods.FECHA_TERMINO_ODS FROM (contrato AS C INNER JOIN ods ON ods.ID_CONTRATO = C.ID_CONTRATO) INNER JOIN actividad AS A ON A.ID_ODS = ods.ID_ODS where (A.FECHA_ACTIVIDAD >= '"+fechai+"' and A.FECHA_ACTIVIDAD <= '"+fechaf+"') AND (C.ID_CONTRATO = "+id+") GROUP BY ods.ID_ODS");

            while(rst.next()){
                cont = new Contrato();
                cont.setNumeroOds(Integer.parseInt(rst.getString(1)));
                cont.setAvanceHoras(Integer.parseInt(rst.getString(2)));
                cont.setTotal_horas(Integer.parseInt(rst.getString(3)));
                cont.setFecha_Termino_ODS(rst.getString(4));
                Actividades.add(cont);
            }
            return Actividades;
       
       }
       catch(Exception ex){
       System.out.println(ex);
       
       return null;
        }
   }
   public ArrayList <Contrato> Actividad_Equipo(String fechai, String fechaf, String id){
        
       ArrayList <Contrato> Actividades = new ArrayList <Contrato>();
       try{
        Contrato contrato;
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("SELECT ods.ID_ODS AS 'Folio ODS', count(A.AVANCE_HORAS) AS 'Horas Utilizadas' FROM (contrato AS C INNER JOIN ods ON ods.ID_CONTRATO = C.ID_CONTRATO) INNER JOIN registro_equipos AS A ON A.ID_ODS = ods.ID_ODS where (A.FECHA_ACTIVIDAD >= '"+fechai+"' and A.FECHA_ACTIVIDAD <= '"+fechaf+"') AND (C.ID_CONTRATO = "+id+") GROUP BY ods.ID_ODS");

            while(rst.next()){
                contrato = new Contrato();
                contrato.setNumeroOds(Integer.parseInt(rst.getString(1)));
                contrato.setAvanceHoras(Integer.parseInt(rst.getString(2)));
                Actividades.add(contrato);
            }
            return Actividades;
       }
       catch(Exception ex){
       System.out.println(ex);
       
       return null;
        }
       
   }
   
   
   
}
