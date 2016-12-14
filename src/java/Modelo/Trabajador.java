package Modelo;

import java.util.*;
import Modelo.Base_de_Datos;
import java.sql.ResultSet;

public class Trabajador extends Base_de_Datos {

//<editor-fold defaultstate="collapsed" desc="Atributos">
    private String turno;
    private Integer jornada;
    private Integer salario;
    private String rutTrabajador;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private Boolean sexo;
    private String nacionalidad;
    private String domicilio;
    private String celular;
    private String eMail;
    private Actividad actividad;
    private String Comuna;
    private String Provincia;
    private String Region;
    private cargo Cargo;
    private Contrato contrato;
    private Documento doc;
//</editor-fold>

    
//<editor-fold defaultstate="collapsed" desc="metodos por defecto">
   public Trabajador() {
      // conectar();
   }

    public Trabajador(String turno, Integer jornada, Integer salario, String rutTrabajador, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, Boolean sexo, String nacionalidad, String domicilio, String celular, String eMail, String Comuna, String Provincia, String Region, cargo Cargo, Contrato contrato) {
        this.turno = turno;
        this.jornada = jornada;
        this.salario = salario;
        this.rutTrabajador = rutTrabajador;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.celular = celular;
        this.eMail = eMail;
        this.Comuna = Comuna;
        this.Provincia = Provincia;
        this.Region = Region;
        this.Cargo = Cargo;
        this.contrato = contrato;
    }
   
   
   
   
   
   public java.util.Collection<Licencia> licencia;
   public java.util.Collection<Examen> Agenda;

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public cargo getCargo() {
        return Cargo;
    }

    public void setCargo(cargo Cargo) {
        this.Cargo = Cargo;
    }
  
   
   
   public String getTurno() {
       return turno;
   }
   
   public void setTurno(String newTurno) {
       turno = newTurno;
   }
   
   public Integer getJornada() {
       return jornada;
   }
   
   public void setJornada(Integer newJornada) {
       jornada = newJornada;
   }
   
   public Integer getSalario() {
       return salario;
   }
   
   public void setSalario(Integer newSalario) {
       salario = newSalario;
   }
   
   public String getRutTrabajador() {
       return rutTrabajador;
   }
   
   public void setRutTrabajador(String newRutTrabajador) {
       rutTrabajador = newRutTrabajador;
   }
   
   public String getNombre() {
       return nombre;
   }
   
   public void setNombre(String newNombre) {
       nombre = newNombre;
   }
   
   public String getApellidoPaterno() {
       return apellidoPaterno;
   }
   
   public void setApellidoPaterno(String newApellidoPaterno) {
       apellidoPaterno = newApellidoPaterno;
   }
   
   public String getApellidoMaterno() {
       return apellidoMaterno;
   }
   
   public void setApellidoMaterno(String newApellidoMaterno) {
       apellidoMaterno = newApellidoMaterno;
   }
   
   public String getFechaNacimiento() {
       return fechaNacimiento;
   }
   
   public void setFechaNacimiento(String newFechaNacimiento) {
       fechaNacimiento = newFechaNacimiento;
   }
   
   public Boolean getSexo() {
       return sexo;
   }
   
   public void setSexo(Boolean newSexo) {
       sexo = newSexo;
   }
   
   public String getNacionalidad() {
       return nacionalidad;
   }
   
   public void setNacionalidad(String newNacionalidad) {
       nacionalidad = newNacionalidad;
   }
   
   public String getDomicilio() {
       return domicilio;
   }
   
   public void setDomicilio(String newDomicilio) {
       domicilio = newDomicilio;
   }
   
   public String getCelular() {
       return celular;
   }
   
   public void setCelular(String newCelular) {
       celular = newCelular;
   }
   
   public String getEMail() {
       return eMail;
   }
   
   public void setEMail(String newEMail) {
       eMail = newEMail;
   }
   
   public Boolean contratarTrabajador(){
       return true;
   }
   
   public Boolean despedirTrabajador(){
       return true;
   }
   
   public Boolean generarAnexo(){
       return true;
   }
   
   public Boolean realizarExamen(){
       return true;
   }
   
   public Boolean certificarConduccion(){
       return true;
   }
   
   public Integer asociarContrato(){
       return 0;
   }
   
   
   public java.util.Collection<Licencia> getLicencia() {
       if (licencia == null)
           licencia = new java.util.HashSet<Licencia>();
       return licencia;
   }
   
   public java.util.Iterator getIteratorLicencia() {
       if (licencia == null)
           licencia = new java.util.HashSet<Licencia>();
       return licencia.iterator();
   }
   
   public void setLicencia(java.util.Collection<Licencia> newLicencia) {
       removeAllLicencia();
       for (java.util.Iterator iter = newLicencia.iterator(); iter.hasNext();)
           addLicencia((Licencia)iter.next());
   }
   
   public void addLicencia(Licencia newLicencia) {
       if (newLicencia == null)
           return;
       if (this.licencia == null)
           this.licencia = new java.util.HashSet<Licencia>();
       if (!this.licencia.contains(newLicencia))
           this.licencia.add(newLicencia);
   }
   
   public void removeLicencia(Licencia oldLicencia) {
       if (oldLicencia == null)
           return;
       if (this.licencia != null)
           if (this.licencia.contains(oldLicencia))
               this.licencia.remove(oldLicencia);
   }
   
   public void removeAllLicencia() {
       if (licencia != null)
           licencia.clear();
   }
   
   public java.util.Collection<Examen> getAgenda() {
       if (Agenda == null)
           Agenda = new java.util.HashSet<Examen>();
       return Agenda;
   }
   
   public java.util.Iterator getIteratorAgenda() {
       if (Agenda == null)
           Agenda = new java.util.HashSet<Examen>();
       return Agenda.iterator();
   }
   
   public void setAgenda(java.util.Collection<Examen> newAgenda) {
       removeAllAgenda();
       for (java.util.Iterator iter = newAgenda.iterator(); iter.hasNext();)
           addAgenda((Examen)iter.next());
   }
   
   public void addAgenda(Examen newExamen) {
       if (newExamen == null)
           return;
       if (this.Agenda == null)
           this.Agenda = new java.util.HashSet<Examen>();
       if (!this.Agenda.contains(newExamen))
           this.Agenda.add(newExamen);
   }
   
   public void removeAgenda(Examen oldExamen) {
       if (oldExamen == null)
           return;
       if (this.Agenda != null)
           if (this.Agenda.contains(oldExamen))
               this.Agenda.remove(oldExamen);
   }
   
   public void removeAllAgenda() {
       if (Agenda != null)
           Agenda.clear();
   }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="metodos actividad">
   public String geteMail() {
       return eMail;
   }
   
   public void seteMail(String eMail) {
       this.eMail = eMail;
   }
   
   public Actividad getActividad() {
       return actividad;
   }
   
   public void setActividad(Actividad actividad) {
       this.actividad = actividad;
   }
   
   public Contrato getContrato() {
       return contrato;
   }
   
   public void setContrato(Contrato contrato) {
       this.contrato = contrato;
   }
//</editor-fold>

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }
   
   
   
public ArrayList actividades(String fecha_inicio, String Fecha_termino, String numero_ods){
    
    ArrayList <Trabajador> actividades = new ArrayList <Trabajador>();
    
    try{
        ResultSet rst;
        getStmt();
        Trabajador cont;
        Actividad actividad = new Actividad();
        rst = stmt.executeQuery("SELECT act.NOMBRE_ACTIVIDAD as Actividad, act.AVANCE_HORAS_TRAB as 'Horas Trabajadas', CONCAT(trab.NOMBRE, ' ', trab.APELLIDO_PATERNO, ' ',trab.APELLIDO_MATERNO) as Trabajador, act.FECHA_ACTIVIDAD 'Fecha Realización' from (ods inner join actividad as act on ods.ID_ODS = act.ID_ODS) INNER JOIN trabajador as trab on trab.RUT_TRABAJADOR = act.RUT_TRABAJADOR where (ods.ID_ODS = "+numero_ods+")");

            while(rst.next()){
                cont = new Trabajador();
                actividad = new Actividad();
                actividad.setNombre_actividad((rst.getString(1)));
                actividad.setAvance_horas_trab(Float.parseFloat(rst.getString(2)));
                cont.setNombre(rst.getString(3));
                actividad.setFecha_actividad(rst.getString(4));
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

public ArrayList cargar_region (ArrayList regiones, String reg){
        try{
            String region;
            ResultSet rst;
            getStmt();
            Trabajador cont;
            Actividad actividad = new Actividad();
            rst = stmt.executeQuery("SELECT NOMBRE_"+reg+" FROM "+reg);
            while(rst.next()){
                region = rst.getString(1);
                regiones.add(region);
            }
        return regiones;
        }catch(Exception ex){
                return null;
                }
}

public ArrayList cargar_contratos (ArrayList regiones){
        try{
            String region;
            ResultSet rst;
            getStmt();
            Trabajador cont;
            Actividad actividad = new Actividad();
            rst = stmt.executeQuery("SELECT NOMBRE_CONTRATO FROM CONTRATO");
            while(rst.next()){
                region = rst.getString(1);
                regiones.add(region);
            }
        return regiones;
        }catch(Exception ex){
                return null;
                }
}

public ArrayList cargar_trabajadores (){
        try{
            ArrayList <Trabajador> trabajadores = new ArrayList <Trabajador>();
            ResultSet rst;
            getStmt();
            Trabajador cont;
            rst = stmt.executeQuery("SELECT NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, E_MAIL, RUT_TRABAJADOR, DOMICILIO  FROM TRABAJADOR");
            while(rst.next()){
                cont = new Trabajador();
                cont.setNombre(rst.getString(1));
                cont.setApellidoPaterno(rst.getString(2));
                cont.setApellidoMaterno(rst.getString(3));
                cont.seteMail(rst.getString(4));
                cont.setRutTrabajador(rst.getString(5));
                cont.setDomicilio(rst.getString(6));
                trabajadores.add(cont);
            }
        return trabajadores;
        }catch(Exception ex){
               System.out.println(ex);
            return null;
                }
}

public String codigo_cargo(String cargo){
    
        try{
            //char[] Cargo = cargo.toCharArray();
        String codigo = null;
        System.out.println(cargo);
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("SELECT CODIGO_CARGO FROM CARGO WHERE NOMBRE_CARGO LIKE '%"+cargo+"%'");
        while(rst.next()){
        codigo = rst.getString("CODIGO_CARGO");
        }
        System.out.println(codigo);
        return codigo;
        }catch(Exception ex){
            
            return null;
        
        }
}

public String codigo_comuna(String comuna){
    
        try{
        String codigo = null;
            char[] Comuna = comuna.toCharArray();
        System.out.println(comuna);
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("SELECT ID_COMUNA FROM COMUNA WHERE NOMBRE_COMUNA LIKE '%"+comuna+"%'");
        while(rst.next()){
        codigo = rst.getString("ID_COMUNA");
        }
        System.out.println(codigo);
        return codigo;
        }catch(Exception ex){
            
            return null;
        
        }
}

public String ingresar_trabajadores(Trabajador trabajador){
    
    try{
        
        String cod_cargo = this.codigo_cargo(trabajador.getCargo().getNombre_cargo());
        String cod_comuna = this.codigo_comuna(trabajador.getComuna());
        
        if(cod_cargo == null || cod_comuna == null) return "Error: Comuna o Cargo no son Válidos";
        
        int rst;
        getStmt();
        rst = stmt.executeUpdate("INSERT INTO TRABAJADOR (TURNO, JORNADA, SALARIO, RUT_TRABAJADOR, ID_USUARIO, CODIGO_CARGO, ID_COMUNA, NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, FECHA_NACIMIENTO, SEXO, NACIONALIDAD, DOMICILIO, CELULAR, E_MAIL)"
                + "VALUES('"+trabajador.getTurno()+"',"+trabajador.getJornada()+","+trabajador.getSalario()+",'"+trabajador.getRutTrabajador()+"',1,"+cod_cargo+","+cod_comuna+",'"+trabajador.getNombre()+"','"+trabajador.getApellidoPaterno()+"', '"+trabajador.getApellidoMaterno()+"', '"+trabajador.getFechaNacimiento()+"',2,'"+trabajador.getNacionalidad()+"','"+trabajador.getDomicilio()+"','"+trabajador.getCelular()+"','"+trabajador.geteMail()+"'      )");
        
       // System.out.println("bien"); 
        return "Trabajador Ingresado Correctamente, se han modificado "+rst+" filas";
    }catch(Exception ex){
        System.out.println("error fatal"); 
        return "Ocurrió un Error al Ingresar el Trabajador: "+ex;
    }
}

public Trabajador desplegar_trabajador(String rut){

    Trabajador trabajador = new Trabajador();
    try{
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("SELECT T.TURNO, T.JORNADA, T.SALARIO, T.RUT_TRABAJADOR, T.NOMBRE, T.APELLIDO_PATERNO, "
                + "T.APELLIDO_MATERNO, '2000-01-01', T.SEXO, T.NACIONALIDAD, T.DOMICILIO, T.CELULAR, T.E_MAIL, "
                + "COM.NOMBRE_COMUNA, PROV.NOMBRE_PROVINCIA, REG.NOMBRE_REGION, C.NOMBRE_CARGO "
                + "FROM ((((TRABAJADOR AS T INNER JOIN comuna AS COM ON T.ID_COMUNA = COM.ID_COMUNA) "
                + "INNER JOIN provincia AS PROV ON COM.CODIGO_PROVINCIA = PROV.CODIGO_PROVINCIA) "
                + "INNER JOIN region AS REG ON PROV.CODIGO_REGION = REG.CODIGO_REGION) "
                + "INNER JOIN cargo AS C ON T.CODIGO_CARGO = C.CODIGO_CARGO) "
                + "WHERE T.RUT_TRABAJADOR LIKE '%"+rut+"%'");
        
        while(rst.next()){
        cargo Cargo = new cargo();
            trabajador.setTurno(rst.getString(1));
            trabajador.setJornada(Integer.parseInt(rst.getString(2)));
            trabajador.setSalario(Integer.parseInt(rst.getString(3)));
            trabajador.setRutTrabajador(rst.getString(4));
            trabajador.setNombre(rst.getString(5));
            trabajador.setApellidoPaterno(rst.getString(6));
            trabajador.setApellidoMaterno(rst.getString(7));
            trabajador.setFechaNacimiento(rst.getString(8));
            trabajador.setSexo(Boolean.parseBoolean(rst.getString(9))); //aslkdjaszgfjkhdlfg
            trabajador.setNacionalidad(rst.getString(10));
            trabajador.setDomicilio(rst.getString(11));
            trabajador.setCelular(rst.getString(12));
            trabajador.seteMail(rst.getString(13));
            trabajador.setComuna(rst.getString(14));
            trabajador.setProvincia(rst.getString(15));
            trabajador.setRegion(rst.getString(16));
            Cargo.setNombre_cargo(rst.getString(17));
            trabajador.setCargo(Cargo);
            trabajador.getCargo().getNombre_cargo();   
        }
        return trabajador;
    }catch(Exception ex){
        
            System.out.println(ex);
            return trabajador;
            }
    }

public ArrayList desplegar_documentos(String rut){
    
    ArrayList documentos = new ArrayList();
    Documento doc = new Documento();
    Trabajador trab = new Trabajador();
    
    try{
    
        ResultSet rst;
        getStmt();
        rst = stmt.executeQuery("SELECT DOC.NOMBRE_DOCUMENTO, DOC.TIPO_DOCUMENTO, DOC.FECHA_VENCIMIENTO FROM TRABAJADOR AS TRAB INNER JOIN documentos AS DOC ON DOC.RUT_TRABAJADOR = TRAB.RUT_TRABAJADOR WHERE TRAB.RUT_TRABAJADOR LIKE '"+rut+"'");
        while(rst.next()){
            
            doc = new Documento();
            trab = new Trabajador();
            doc.setNombre_documento(rst.getString(1));
            doc.setTipo_documento(rst.getString(2));
            doc.setFecha_vencimiento(rst.getString(3));
            trab.setDoc(doc);
            documentos.add(trab);
            
        } 
        System.out.println("Todo OK!");
        return documentos;    
    }catch(Exception ex){
    System.out.println(ex);
    return null;
    }
    
    
}

}