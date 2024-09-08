package com.example.lab2_20213704.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Usuario implements Serializable {

   private String nombre;
   private ArrayList<String> listaIntentos;

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public ArrayList<String> getListaIntentos() {
      return listaIntentos;
   }

   public void setListaIntentos(ArrayList<String> listaIntentos) {
      this.listaIntentos = listaIntentos;
   }
}
