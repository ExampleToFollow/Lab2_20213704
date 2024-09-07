package com.example.lab2_20213704.Beans;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class Usuario implements Serializable {

   private String nombre;
   private String palabraSecreta;
   private String palabraIntento;
   private LinkedHashMap<Integer , String > listaIntentos;

   public Usuario(String nombre, String palabraSecreta) {
      this.nombre = nombre;
      this.palabraSecreta = palabraSecreta;
      this.palabraIntento = "";
      this.listaIntentos = new LinkedHashMap<Integer, String >();
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getPalabraSecreta() {
      return palabraSecreta;
   }

   public void setPalabraSecreta(String palabraSecreta) {
      this.palabraSecreta = palabraSecreta;
   }

   public String getPalabraIntento() {
      return palabraIntento;
   }

   public void setPalabraIntento(String palabraIntento) {
      this.palabraIntento = palabraIntento;
   }

   public LinkedHashMap<Integer, String> getListaIntentos() {
      return listaIntentos;
   }

   public void setListaIntentos(LinkedHashMap<Integer, String> listaIntentos) {
      this.listaIntentos = listaIntentos;
   }
}
