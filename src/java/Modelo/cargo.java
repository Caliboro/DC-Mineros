/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author thebe
 */
public class cargo {
    
    private String nombre_cargo;
    private int codigo_cargo;

//<editor-fold defaultstate="collapsed" desc="metodos default">
    public cargo(String nombre_cargo, int codigo_cargo) {
        this.nombre_cargo = nombre_cargo;
        this.codigo_cargo = codigo_cargo;
    }
    
    public cargo() {
    }
    
    
    
    public String getNombre_cargo() {
        return nombre_cargo;
    }
    
    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }
    
    public int getCodigo_cargo() {
        return codigo_cargo;
    }
    
    public void setCodigo_cargo(int codigo_cargo) {
        this.codigo_cargo = codigo_cargo;
    }
//</editor-fold>
    
    
    
}
