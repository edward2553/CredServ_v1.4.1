package com.credserv.persistencia;

import com.credserv.entidades.LogAuditoria;
import com.credserv.utilidades.Conexion;
import java.sql.PreparedStatement;

public class LogAuditoriaDAO {

    
    Conexion con = new Conexion();
    
    public boolean insertarLog(LogAuditoria auditoria){
        
        try {
            PreparedStatement log = con.obtenerConexion().prepareStatement("INSERT INTO LOG_AUDITORIA (ID_USUARIO_LOG, MODULO,"
                    + "CAMBIO_REALIZADO, FECHA_CAMBIO, HORA_CAMBIO) VALUES (?,?,?,?,?)");
            log.setInt(1, auditoria.getIdUsuarioLog());
            log.setString(2, auditoria.getModulo());
            log.setString(3, auditoria.getCambioRealizado());
            log.setString(4, auditoria.getFechaCambio());
            log.setString(5, auditoria.getHoraCambio());
            log.execute();
            
        } catch (Exception e) {
            e.getCause();
            e.getMessage();
            return false;
        }
        return true;
        
    }
}
