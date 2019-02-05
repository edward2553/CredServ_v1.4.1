/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import com.credserv.entidades.Cliente;
import com.credserv.servlets.InsertarClienteYservicio;
import com.credserv.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author crist
 */
public class ClienteDAO {

    Conexion con = new Conexion();

    public boolean insertarCliente(Cliente cli) {
        try {
            PreparedStatement insAutomotor = con.obtenerConexion().prepareStatement("insert into CLIENTE (CEDULA_CONDUCTOR,"
                    + "NOMBRE_CONDUCTOR,APELLIDO_CONDUCTOR) values (?,?,?)");
            insAutomotor.setString(1, cli.getCedula_conductor());
            insAutomotor.setString(2, cli.getNombre_conductor());
            insAutomotor.setString(3, cli.getApellido_conductor());
            insAutomotor.execute();

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

    /**
     * es falso si la cedula ya existe
     *por ejemplo yo quiero ingresar un cliente con diferente nombre pero con misma cedula, no te debe dejar
     * @param cli
     * @return
     */
    public boolean SicedulaExiste(Cliente cli) {
        boolean validacion = false;
        try {
            ResultSet rs = con.obtenerConexion().prepareStatement("select * from CLIENTE where CEDULA_CONDUCTOR = " + cli.getCedula_conductor() + "").executeQuery();

            while (rs.next()) {
                String cedula2 = rs.getString(2);

                if (cedula2.equals(cli.getCedula_conductor())) {
                    validacion = true;
                }
            }

        } catch (Exception e) {
            e.getCause();
            e.getMessage();
        }
        return validacion;
    }

    /**
     * Valida si existe el cliente para poder ingresar los servicios a su nombre
     *
     * @param cli
     * @return
     */
    public boolean siExisteCliente(Cliente cli) {
        boolean validacion = false;
        try {
            ResultSet rs = con.obtenerConexion().prepareStatement("select * from CLIENTE where CEDULA_CONDUCTOR = " + cli.getCedula_conductor() + "").executeQuery();
            //verificando si el cliente del front corresponde al de la base de datos
            String cedula;
            String nombre;
            String apellido;
            while (rs.next()) {
                cedula = rs.getString(2);
                nombre = rs.getString(3);
                apellido = rs.getString(4);
                if (cedula.equals(cli.getCedula_conductor()) && nombre.equalsIgnoreCase(cli.getNombre_conductor()) && apellido.equalsIgnoreCase(cli.getApellido_conductor())) {
                    validacion = true;
                }
            }

        } catch (Exception e) {
            e.getCause();
            e.getMessage();
        }
        return validacion;
    }

}
