package Modelo;


import java.util.*;

public class CarpetaDeArranque {

   private int idCarpetaArranque;
   private String nombreCarpeta;
   private String cartaSernageomin;
   private String cartaSeremiSalud;
   private String cartaSeremiPrograma;
   private String contratoTrabajoServicios;
   private String conocimientoNormativas;
   private String documentoEstudioTecnico;

    public CarpetaDeArranque(int idCarpetaArranque, String nombreCarpeta, String cartaSernageomin, String cartaSeremiSalud, String cartaSeremiPrograma, String contratoTrabajoServicios, String conocimientoNormativas, String documentoEstudioTecnico) {
        this.idCarpetaArranque = idCarpetaArranque;
        this.nombreCarpeta = nombreCarpeta;
        this.cartaSernageomin = cartaSernageomin;
        this.cartaSeremiSalud = cartaSeremiSalud;
        this.cartaSeremiPrograma = cartaSeremiPrograma;
        this.contratoTrabajoServicios = contratoTrabajoServicios;
        this.conocimientoNormativas = conocimientoNormativas;
        this.documentoEstudioTecnico = documentoEstudioTecnico;
    }
   
   
   
   protected void finalize() {
      // TODO: implement
   }
   
   public int getIdCarpetaArranque() {
      return idCarpetaArranque;
   }
   public void setIdCarpetaArranque(int newIdCarpetaArranque) {
      idCarpetaArranque = newIdCarpetaArranque;
   }
   public String getNombreCarpeta() {
      return nombreCarpeta;
   }
   public void setNombreCarpeta(String newNombreCarpeta) {
      nombreCarpeta = newNombreCarpeta;
   }
   public String getCartaSernageomin() {
      return cartaSernageomin;
   }
   public void setCartaSernageomin(String newCartaSernageomin) {
      cartaSernageomin = newCartaSernageomin;
   }
   public String getCartaSeremiSalud() {
      return cartaSeremiSalud;
   }
   public void setCartaSeremiSalud(String newCartaSeremiSalud) {
      cartaSeremiSalud = newCartaSeremiSalud;
   }
   public String getCartaSeremiPrograma() {
      return cartaSeremiPrograma;
   }
   public void setCartaSeremiPrograma(String newCartaSeremiPrograma) {
      cartaSeremiPrograma = newCartaSeremiPrograma;
   }
   public String getContratoTrabajoServicios() {
      return contratoTrabajoServicios;
   }
   public void setContratoTrabajoServicios(String newContratoTrabajoServicios) {
      contratoTrabajoServicios = newContratoTrabajoServicios;
   }
   public String getConocimientoNormativas() {
      return conocimientoNormativas;
   }
   public void setConocimientoNormativas(String newConocimientoNormativas) {
      conocimientoNormativas = newConocimientoNormativas;
   }
   public String getDocumentoEstudioTecnico() {
      return documentoEstudioTecnico;
   }
   public void setDocumentoEstudioTecnico(String newDocumentoEstudioTecnico) {
      documentoEstudioTecnico = newDocumentoEstudioTecnico;
   }

}
