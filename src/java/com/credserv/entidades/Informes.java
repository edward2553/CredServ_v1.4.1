/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.entidades;

/**
 *
 * @author edwar
 */
public class Informes {

    private String duracionTotal;
    private int precioTotal;
    private int totalServicios;

    private int codigoPdf;
    private String nombrePdf;
    public Informes(String duracion, int precio, int servicios) {

        duracionTotal = duracion;
        precioTotal = precio;
        totalServicios = servicios;
        

    }

    /**
     * @return the duracionTotal
     */
    public String getDuracionTotal() {
        return duracionTotal;
    }

    /**
     * @param duracionTotal the duracionTotal to set
     */
    public void setDuracionTotal(String duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    /**
     * @return the precioTotal
     */
    public int getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * @return the totalServicios
     */
    public int getTotalServicios() {
        return totalServicios;
    }

    /**
     * @param totalServicios the totalServicios to set
     */
    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

}
