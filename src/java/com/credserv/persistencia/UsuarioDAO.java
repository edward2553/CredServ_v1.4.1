/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import com.credserv.entidades.Usuario;
import com.credserv.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    Conexion con = new Conexion();

    public boolean insertarOperador(Usuario usu) {
        try {
            PreparedStatement insUsuario = con.obtenerConexion().prepareStatement("INSERT INTO USUARIO (PRIMER_NOMBRE,SEGUNDO_NOMBRE,"
                    + "PRIMER_APELLIDO, SEGUNDO_APELLIDO, IDENTIFICACION, EDAD_USUARIO, EMAIL, CLAVE, TELEFONO,DIRECCION, NIVEL )"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            insUsuario.setString(1, usu.getPrimerNombre());
            insUsuario.setString(2, usu.getSegundoNombre());
            insUsuario.setString(3, usu.getPrimerApellido());
            insUsuario.setString(4, usu.getSegundoApellido());
            insUsuario.setString(5, usu.getIdentificacion());
            insUsuario.setInt(6, usu.getEdad());
            insUsuario.setString(7, usu.getEmail());
            insUsuario.setString(8, usu.getClave());
            insUsuario.setString(9, usu.getTelefono());
            insUsuario.setString(10, usu.getDireccion());
            insUsuario.setInt(11, usu.getNivel());
            insUsuario.execute();

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

    public boolean ValidarUsuario(String email) {

        boolean validacion = false;
        try {

            Usuario usu = new Usuario();
            ResultSet validar = con.obtenerConexion().prepareStatement("select * from USUARIO where EMAIL = '" + email + "'").executeQuery();

            
            while (validar.next()) {
                String correo = validar.getString(7);

                if (correo.equals(usu.getEmail())) {
                    validacion = false;
                } else {
                    validacion = true;
                }

            }
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }
        return validacion;
    }

    public boolean EliminarOperador(String idUsuario) {
        try {
            PreparedStatement consultaPreparada = con.obtenerConexion().prepareStatement("DELETE FROM USUARIO WHERE ID_USUARIO = '" + idUsuario + "'");
            consultaPreparada.execute();
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    public boolean EditarOperador(Usuario usu) {

        try {
            PreparedStatement editar = con.obtenerConexion().prepareStatement("UPDATE USUARIO SET PRIMER_NOMBRE = ?,SEGUNDO_NOMBRE = ?,"
                    + "PRIMER_APELLIDO = ?, SEGUNDO_APELLIDO = ?, IDENTIFICACION = ?, EDAD_USUARIO = ?, CLAVE = ?,"
                    + "TELEFONO = ?, DIRECCION = ? WHERE EMAIL = ?");
            editar.setString(1, usu.getPrimerNombre());
            editar.setString(2, usu.getSegundoNombre());
            editar.setString(3, usu.getPrimerApellido());
            editar.setString(4, usu.getSegundoApellido());
            editar.setString(5, usu.getIdentificacion());
            editar.setInt(6, usu.getEdad());
            editar.setString(7, usu.getClave());
            editar.setString(8, usu.getTelefono());
            editar.setString(9, usu.getDireccion());
            editar.setString(10, usu.getEmail());
            editar.execute();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
}
