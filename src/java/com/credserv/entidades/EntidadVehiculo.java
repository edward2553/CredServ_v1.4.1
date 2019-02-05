/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.entidades;

public class EntidadVehiculo {
    
    private int IDVehiculo;
    private String NombreVehiculo;

    public EntidadVehiculo(String NombreVehiculo, int IDVehiculo) {
        this.NombreVehiculo = NombreVehiculo;
        this.IDVehiculo = IDVehiculo;
    }
    
    public EntidadVehiculo(String NombreVehiculo) {
        this.NombreVehiculo = NombreVehiculo;
    }
    
    
    public EntidadVehiculo() {
    }

    public int getIDVehiculo() {
        return IDVehiculo;
    }

    public void setIDVehiculo(int IDVehiculo) {
        this.IDVehiculo = IDVehiculo;
    }
    
    public String getNombreVehiculo() {
        return NombreVehiculo;
    }

    public void setNombreVehiculo(String NombreVehiculo) {
        this.NombreVehiculo = NombreVehiculo;
    }
}
