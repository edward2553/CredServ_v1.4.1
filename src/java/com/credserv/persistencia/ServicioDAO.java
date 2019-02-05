package com.credserv.persistencia;

import com.credserv.entidades.Servicio;
import com.credserv.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicioDAO {

    Conexion con = new Conexion();

    public boolean insertarServicio(Servicio serv) {
        try {

            PreparedStatement insServicio = con.obtenerConexion().prepareStatement("insert into SERVICIOS_DIARIOS (CEDULA_CLIENTE,PLACA_AUTOMOTOR,ID_TIPO_VEHICULO,"
                    + "ID_TIPO_SERVICIO,HORA_ENTRADA,HORA_SALIDA,FECHA_ENTRADA,ID_USUARIO_SERVICIOS, PRECIO_TOTAL, PORC_DESCUENTO, TOTAL_DESCUENTO,VAL_SERVICIO_INDIVIDUAL,TOTAL_SIN_DESCUENTO,TURNO,DURAC_MIN,DURAC_HORA) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            insServicio.setString(1, serv.getCedula());
            insServicio.setString(2, serv.getPlaca_automotor());
            insServicio.setInt(3, serv.getId_tipo_automotor());
            insServicio.setInt(4, serv.getId_tipo_servicio());
            insServicio.setString(5, serv.getHora_entrada());
            insServicio.setString(6, serv.getHora_salida());
            insServicio.setString(7, serv.getFecha_entrada());
            insServicio.setInt(8, serv.getID_usuario());
            insServicio.setDouble(9, serv.getPrecio());
            insServicio.setDouble(10, serv.getPorc_descuento());
            insServicio.setDouble(11, serv.getTotal_descuento());         
            insServicio.setDouble(12, serv.getValor_servicio_individual());
            insServicio.setDouble(13, serv.getTotal_sinDescuento());
            insServicio.setString(14, serv.getTurno());
            insServicio.setString(15, serv.getDurac_minutos());
            insServicio.setString(16, serv.getDurac_horas());
            insServicio.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return false;
        }
        return true;
    }

    public double BuscarPrecio(int ID_Servicio, int ID_Vehiculo) {
      double precio =0;
        try {
            ResultSet ConsultaPrecio = con.obtenerConexion().prepareStatement("select * from TABLA_SERVICIOS_SERVITECA "
                    + "where SERVICIOS_ID_TIPO_SERVICIO = '" + ID_Servicio + "' and SERVICIOS_ID_TIPO_VEHICULO = '" + ID_Vehiculo + "' ").executeQuery();

            
            while (ConsultaPrecio.next()) {
                precio = ConsultaPrecio.getDouble(3);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
     return precio;   
    }
    
     public double BuscarCantidadServicios() {
      double CantidadServicios = 0;
        try {
            ResultSet consulta = con.obtenerConexion().prepareStatement("SELECT * FROM DESCUENTO").executeQuery();

            
            while (consulta.next()) {
                CantidadServicios = consulta.getDouble(1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
     return CantidadServicios;   
    }
    
    public double BuscarDescuento() {
      double Descuento = 0;
        try {
            ResultSet consulta = con.obtenerConexion().prepareStatement("SELECT * FROM DESCUENTO").executeQuery();

            
            while (consulta.next()) {
                Descuento = consulta.getDouble(2);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
     return Descuento;   
    }
    public boolean BuscarTurno(String turno){
    
        boolean validar = false;
        try {
            ResultSet consultaTurno = con.obtenerConexion().prepareStatement("SELECT * FROM SERVICIOS_DIARIOS WHERE TURNO = '"+turno+"'").executeQuery();
            if (consultaTurno.next()) {
                validar = true;
            }else{
                validar = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    
    return validar;
    }

}
