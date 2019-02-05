/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.entidades;

/**
 *
 * @author crist
 */
public class EntidadServicio {

    private String Servicio;
     private int IDServicio;


    public EntidadServicio(String Servicio, int IDServicio) {
        this.Servicio = Servicio;
        this.IDServicio = IDServicio;
    }
   

    public EntidadServicio(String servicio) {
        this.Servicio = servicio;
    }

    public EntidadServicio() {
    }
    
    
    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }
    public String getNombre() {
        return Servicio;
    }

    public void setNombre(String nombre) {
        this.Servicio = nombre;
    }
    
    
}
