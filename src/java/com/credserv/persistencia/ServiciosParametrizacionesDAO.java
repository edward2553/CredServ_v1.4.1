/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import com.credserv.entidades.EntidadServicio;
import com.credserv.entidades.EntidadServiciosServiteca;
import com.credserv.entidades.EntidadVehiculo;
import com.credserv.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author crist
 */
public class ServiciosParametrizacionesDAO {

    Conexion con = new Conexion();

    public ServiciosParametrizacionesDAO() {

    }

    public boolean insertarServicio(EntidadServicio prueba) {
        try {
            PreparedStatement insPrueba = con.obtenerConexion().prepareStatement("insert into TIPO_SERVICIO_SERVITECA (TIPO_SERVICIO_SERVITECA) values (?)");
            insPrueba.setString(1, prueba.getNombre());
            insPrueba.execute();

        } catch (Exception e) {
            e.getCause();
            e.getMessage();
            return false;
        }

        return true;
    }

    public boolean existeServicio(EntidadServicio prueba) {

        try {
            ResultSet rs = con.obtenerConexion().prepareStatement("SELECT * FROM TIPO_SERVICIO_SERVITECA").executeQuery();
            while (rs.next()) {
                String nombreServicio = rs.getString(2);
                if (nombreServicio.equals(prueba.getNombre())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }
        return false;
    }

    public boolean insertarVehiculo(EntidadVehiculo insVehi) {
        try {
            PreparedStatement insPrueba = con.obtenerConexion().prepareStatement("insert into TIPO_VEHICULO_SERVITECA (TIPO_VEHICULO_SERVITECA) values (?)");
            insPrueba.setString(1, insVehi.getNombreVehiculo());
            insPrueba.execute();

        } catch (Exception e) {
            e.getCause();
            e.getMessage();
            return false;
        }

        return true;
    }

    public boolean existeVehiculo(EntidadVehiculo prueba) {

        try {
            ResultSet rs = con.obtenerConexion().prepareStatement("SELECT * FROM TIPO_VEHICULO_SERVITECA").executeQuery();
            while (rs.next()) {
                String nombreServicio = rs.getString(2);
                if (nombreServicio.equals(prueba.getNombreVehiculo())) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public int BuscarVehiculoTEST(String vehiculo) {
        int id = 0;

        try {
            ResultSet busServi = con.obtenerConexion().prepareStatement("SELECT * FROM TIPO_VEHICULO_SERVITECA WHERE TIPO_VEHICULO_SERVITECA = '" + vehiculo + "'").executeQuery();

            while (busServi.next()) {
                id = busServi.getInt(1);
            }

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }
        return id;
    }

//    /**
//     * si ya esta el precio insertado
//     *
//     * @param ServiciosServiteca
//     * @return
//     */
//    public boolean siPrecioExiste(int idservicio, int idVehiculo,String nombreVehiculo, String nombreServicio) {
//
//        try {
//            ResultSet rs = con.obtenerConexion().prepareStatement("SELECT * FROM TABLA_SERVICIOS_SERVITECA WHERE SERVICIOS_ID_TIPO_SERVICIO = " + idservicio + " AND SERVICIOS_ID_TIPO_VEHICULO =" + idVehiculo).executeQuery();
//
//            while(rs.next()){
//            if(nombreVehiculo = rs.getString(1))
//            }
//        } catch (Exception e) {
//        }
//
//    }
    public boolean insertarServiciosServiteca(EntidadServiciosServiteca ServiciosServiteca) {
        try {

            PreparedStatement insServicioServiteca = con.obtenerConexion().prepareStatement("insert into TABLA_SERVICIOS_SERVITECA values (?,?,?)");
            insServicioServiteca.setInt(1, ServiciosServiteca.getIDServiciosServiteca());
            insServicioServiteca.setInt(2, ServiciosServiteca.getIDVehiculosServiteca());
            insServicioServiteca.setString(3, ServiciosServiteca.getPrecio());
            insServicioServiteca.execute();
            return true;
        } catch (Exception e) {
            e.getCause();
            e.getMessage();
            return false;
        }

    }

    public boolean existeServicioServiteca(int IDServico, int IDVehiculo) {

        try {
            ResultSet rs = con.obtenerConexion().prepareStatement("SELECT * FROM TABLA_SERVICIOS_SERVITECA").executeQuery();
            while (rs.next()) {
                int idservicio = rs.getInt(1);
                int idvehiculo = rs.getInt(2);
                if (idservicio == IDServico && idvehiculo == IDVehiculo) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }
        return false;
    }

    public boolean EliminarServiciosServiteca(int IDServicios, int IDVehiculo) {
        try {
            PreparedStatement eliminar = con.obtenerConexion().prepareStatement("DELETE FROM TABLA_SERVICIOS_SERVITECA "
                    + "WHERE SERVICIOS_ID_TIPO_SERVICIO = '" + IDServicios + "' AND SERVICIOS_ID_TIPO_VEHICULO = '" + IDVehiculo + "'");
            eliminar.execute();

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

    public boolean EliminarServicios(int IDServicios) {
        try {
            PreparedStatement eliminar = con.obtenerConexion().prepareStatement("DELETE FROM TIPO_SERVICIO_SERVITECA WHERE ID_TIPO_SERVICIO_SERVITECA = '" + IDServicios + "'");
            eliminar.execute();

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

    public int BuscarServicioTEST(String servicio) {
        int id = 0;

        try {
            ResultSet busServi = con.obtenerConexion().prepareStatement("SELECT * FROM TIPO_SERVICIO_SERVITECA WHERE TIPO_SERVICIO_SERVITECA = '" + servicio + "'").executeQuery();

            while (busServi.next()) {
                id = busServi.getInt(1);
            }

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }
        return id;
    }

    public boolean EliminarVehiculos(int IDVehiculo) {
        try {
            PreparedStatement eliminar = con.obtenerConexion().prepareStatement("DELETE FROM TIPO_VEHICULO_SERVITECA WHERE ID_TIPO_VEHICULO_SERVITECA = '" + IDVehiculo + "'");
            eliminar.execute();

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

    public boolean EditarServicio(EntidadServicio servicio) {
        try {
            PreparedStatement editar = con.obtenerConexion().prepareStatement("UPDATE TIPO_SERVICIO_SERVITECA SET TIPO_SERVICIO_SERVITECA = ? WHERE ID_TIPO_SERVICIO_SERVITECA = ?");
            editar.setString(1, servicio.getNombre());
            editar.setInt(2, servicio.getIDServicio());
            editar.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

    public boolean EditarVehiculo(EntidadVehiculo vehiculo) {
        try {
            PreparedStatement editar = con.obtenerConexion().prepareStatement("UPDATE TIPO_VEHICULO_SERVITECA SET TIPO_VEHICULO_SERVITECA = ? WHERE ID_TIPO_VEHICULO_SERVITECA = ?");
            editar.setString(1, vehiculo.getNombreVehiculo());
            editar.setInt(2, vehiculo.getIDVehiculo());
            editar.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

    public boolean EditarPrecio(EntidadServiciosServiteca servicios) {
        try {
            PreparedStatement editar = con.obtenerConexion().prepareStatement("UPDATE TABLA_SERVICIOS_SERVITECA SET PRECIO = ? WHERE SERVICIOS_ID_TIPO_VEHICULO = ? AND SERVICIOS_ID_TIPO_SERVICIO = ?");
            editar.setString(1, servicios.getPrecio());
            editar.setInt(2, servicios.getIDVehiculosServiteca());
            editar.setInt(3, servicios.getIDServiciosServiteca());
            editar.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            return false;
        }
        return true;
    }

}
