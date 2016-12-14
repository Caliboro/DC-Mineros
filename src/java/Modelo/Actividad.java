package Modelo;

import java.util.Date;
import Modelo.Base_de_Datos;

public class Actividad extends Base_de_Datos {
    
    private String nombre_actividad;
    private String fecha_actividad;
    private String tipo_actividad;
    private float avance_horas_trab;

    public Actividad() {
       
    }
    public Actividad(String nombre_actividad, String fecha_actividad, String tipo_actividad) {
        this.nombre_actividad = nombre_actividad;
        this.fecha_actividad = fecha_actividad;
        this.tipo_actividad = tipo_actividad;
    }

    public float getAvance_horas_trab() {
        return avance_horas_trab;
    }

    public void setAvance_horas_trab(float avance_horas_trab) {
        this.avance_horas_trab = avance_horas_trab;
    }
    
    public String getNombre_actividad() {
        return nombre_actividad;
    }
    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }
    public String getFecha_actividad() {
        return fecha_actividad;
    }
    public void setFecha_actividad(String fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }
    public String getTipo_actividad() {
        return tipo_actividad;
    }
    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }
    
    
    
    
}
