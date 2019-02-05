/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import com.credserv.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edwar
 */
public class informesDao {

    Conexion con = new Conexion();

    /**
     * obtener la duracion de cierto rango de fecha
     *
     * @return
     */
    public String obtenerDuracion(String fechaIncio, String fechaFin) {

        try {
            ResultSet duraciones = con.obtenerConexion().prepareStatement("select DURAC_HORA,DURAC_MIN from SERVICIOS_DIARIOS where FECHA_ENTRADA BETWEEN '" + fechaIncio + "' AND '" + fechaFin + "'").executeQuery();

            String duracionH;
            String duracionM;
            int acumuladorHoras = 0;
            int acumuladorMinutos = 0;
            int i = 0;
            int promedioHoras = 0, promedioMinutos = 0;
            String duracionTotal;
            while (duraciones.next()) {
                duracionH = duraciones.getString(1);
                duracionM = duraciones.getString(2);
                acumuladorHoras += Integer.parseInt(duracionH);
                acumuladorMinutos += Integer.parseInt(duracionM);
                i++;
            }
            promedioHoras = acumuladorHoras / i;
            promedioMinutos = acumuladorMinutos / i;
            duracionTotal = Integer.toString(promedioHoras) + ":" + Integer.toString(promedioMinutos);

            return duracionTotal;
        } catch (Exception e) {
            e.getCause();
            e.getMessage();
        }
        return "";
    }

    /**
     * obtener el Precio total de cierto rango de fecha
     *
     * @return
     */
    public int obtenerPrecioTotal(String fechaIncio, String fechaFin) {

        try {
            ResultSet precioTotal = con.obtenerConexion().prepareStatement("select PRECIO_TOTAL from SERVICIOS_DIARIOS where FECHA_ENTRADA BETWEEN '" + fechaIncio + "' AND '" + fechaFin + "'").executeQuery();
            int acumuladorPrecio = 0;
            while (precioTotal.next()) {
                acumuladorPrecio += precioTotal.getInt(1);
            }
            
            return acumuladorPrecio;
        } catch (Exception e) {
            e.getCause();
            e.getMessage();
        }
        return 0;
    }

    /**
     * obtener la cantidad de servicios realizados en un rango de fecha
     *
     * @return
     */
    public int obtenerTotalServicios(String fechaIncio, String fechaFin) {

        try {
            ResultSet servicios = con.obtenerConexion().prepareStatement("select ID_SERVICIO from SERVICIOS_DIARIOS where FECHA_ENTRADA BETWEEN '" + fechaIncio + "' AND '" + fechaFin + "'").executeQuery();
            int i = 0;
            while (servicios.next()) {
                i++;
            }
            return i;
        } catch (Exception e) {
            e.getCause();
            e.getMessage();
        }
        return 0;
    }

}
