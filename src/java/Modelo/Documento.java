package Modelo;

import java.util.Date;


public class Documento {
    
    public int id_codumento;
    public String nombre_documento;
    public String tipo_documento;
    public String fecha_vencimiento;

    public Documento() {
    }
    
    

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getId_codumento() {
        return id_codumento;
    }
    
    public void setId_codumento(int id_codumento) {
        this.id_codumento = id_codumento;
    }
    
    public String getNombre_documento() {
        return nombre_documento;
    }
    
    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }
    
    public String getTipo_documento() {
        return tipo_documento;
    }
    
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    
    public String getFehca_vencimiento() {
        return fecha_vencimiento;
    }
    
    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
//</editor-fold>
    
    
    
    
}
