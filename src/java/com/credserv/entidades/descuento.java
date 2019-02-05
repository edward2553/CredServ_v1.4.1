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
public class descuento {


    
    private int cant_servicios;
    private int porc_descuento;

    public descuento(int cant_servicios,int porc_descuento){
        this.cant_servicios = cant_servicios;
        this.porc_descuento = porc_descuento;
    }
    
    
        /**
     * @return the cant_servicios
     */
    public int getCant_servicios() {
        return cant_servicios;
    }

    /**
     * @param cant_servicios the cant_servicios to set
     */
    public void setCant_servicios(int cant_servicios) {
        this.cant_servicios = cant_servicios;
    }

    /**
     * @return the porc_descuento
     */
    public int getPorc_descuento() {
        return porc_descuento;
    }

    /**
     * @param porc_descuento the porc_descuento to set
     */
    public void setPorc_descuento(int porc_descuento) {
        this.porc_descuento = porc_descuento;
    }
    
    
}