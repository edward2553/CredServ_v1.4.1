/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import com.credserv.entidades.Usuario;
import com.credserv.utilidades.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioDAO {

    Conexion con = new Conexion();

    public InicioDAO() {

    }

    public boolean validarInicio(String correoUsuario, String claveUsuario) throws SQLException {

        ResultSet rs = con.obtenerConexion().prepareStatement("select * from USUARIO where EMAIL = '" + correoUsuario + "'").executeQuery();

        boolean validacion = false;

        while (rs.next()) {
            String correo = rs.getString(8);
            String clave = rs.getString(9);

            if (correo.equals(correoUsuario) && clave.equals(claveUsuario)) {
                validacion = true;
            } else {
                validacion = false;
            }
        }
        return validacion;
    }

    public Usuario getUsuario(String correo) throws SQLException {
        Usuario usu = new Usuario();

        ResultSet rs = con.obtenerConexion().prepareStatement("select * from USUARIO where EMAIL = '" + correo + "'").executeQuery();
        
        while (rs.next()) {            
            usu.setPrimerNombre(rs.getString(2));
            usu.setSegundoNombre(rs.getString(3));
            usu.setPrimerApellido(rs.getString(4));
            usu.setSegundoApellido(rs.getString(5));
            usu.setIdentificacion(rs.getString(6));
            usu.setEdad(rs.getInt(7));
            usu.setEmail(rs.getString(8));
            usu.setClave(rs.getString(9));
            usu.setTelefono(rs.getString(10));
            usu.setDireccion(rs.getString(11));
            usu.setNivel(rs.getInt(12));
        }
        return usu;
    }

}
