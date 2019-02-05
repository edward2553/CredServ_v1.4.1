/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.entidades;

public class Cliente {

    private String cedula_conductor;
    private String nombre_conductor;
    private String apellido_conductor;

    public Cliente(String cedula_conductor, String nombre_conductor, String apellido_conductor) {
        this.cedula_conductor = cedula_conductor;
        this.nombre_conductor = nombre_conductor;
        this.apellido_conductor = apellido_conductor;
    }
    public Cliente(){
    
    }


    public String getCedula_conductor() {
        return cedula_conductor;
    }

    public void setCedula_conductor(String cedula_conductor) {
        this.cedula_conductor = cedula_conductor;
    }

    public String getNombre_conductor() {
        return nombre_conductor;
    }

    public void setNombre_conductor(String nombre_conductor) {
        this.nombre_conductor = nombre_conductor;
    }

    public String getApellido_conductor() {
        return apellido_conductor;
    }

    public void setApellido_conductor(String apellido_conductor) {
        this.apellido_conductor = apellido_conductor;
    }

    
}
