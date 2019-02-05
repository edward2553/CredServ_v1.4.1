/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import com.credserv.utilidades.Conexion;
import com.credserv.entidades.descuento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author edwar
 */
public class DescuentoDao {

    Conexion con = new Conexion();

    public boolean EditarDescuento(descuento desc) {
        try {
            PreparedStatement insDatosDescuento = con.obtenerConexion().prepareStatement("UPDATE DESCUENTO SET CANT_SERVICIOS = ?, PORC_DESC = ?");
            insDatosDescuento.setDouble(1, desc.getCant_servicios());
            insDatosDescuento.setDouble(2, desc.getPorc_descuento());
            insDatosDescuento.execute();

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }


}