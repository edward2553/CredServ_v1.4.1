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
public class EntidadServiciosServiteca {

    /**
     * @return the nombreServicio
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * @param nombreServicio the nombreServicio to set
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    /**
     * @return the nombreVehiculo
     */
    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    /**
     * @param nombreVehiculo the nombreVehiculo to set
     */
    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    private int IDServiciosServiteca;
    private int IDVehiculosServiteca;
    private String nombreServicio;
    private String nombreVehiculo;
    private String Precio;

    public EntidadServiciosServiteca() {
    }

    public EntidadServiciosServiteca(int IDServiciosServiteca, int IDVehiculosServiteca, String Precio) {
        this.IDServiciosServiteca = IDServiciosServiteca;
        this.IDVehiculosServiteca = IDVehiculosServiteca;
        this.Precio = Precio;
    }

    public int getIDServiciosServiteca() {
        return IDServiciosServiteca;
    }

    public void setIDServiciosServiteca(int IDServiciosServiteca) {
        this.IDServiciosServiteca = IDServiciosServiteca;
    }

    public int getIDVehiculosServiteca() {
        return IDVehiculosServiteca;
    }

    public void setIDVehiculosServiteca(int IDVehiculosServiteca) {
        this.IDVehiculosServiteca = IDVehiculosServiteca;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
}
