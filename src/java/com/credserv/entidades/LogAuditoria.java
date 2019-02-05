/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.entidades;

/**
 *
 * @author crist
 */
public class LogAuditoria {

    private int IdUsuarioLog;
    private String Modulo;
    private String CambioRealizado;
    private String FechaCambio;
    private String HoraCambio;

    public LogAuditoria() {
    }

    public LogAuditoria(int IdUsuarioLog, String Modulo, String CambioRealizado, String FechaCambio, String HoraCambio) {
        this.IdUsuarioLog = IdUsuarioLog;
        this.Modulo = Modulo;
        this.CambioRealizado = CambioRealizado;
        this.FechaCambio = FechaCambio;
        this.HoraCambio = HoraCambio;
    }

    public int getIdUsuarioLog() {
        return IdUsuarioLog;
    }

    public void setIdUsuarioLog(int NombreUsuarioLog) {
        this.IdUsuarioLog = NombreUsuarioLog;
    }

    public String getModulo() {
        return Modulo;
    }

    public void setModulo(String Modulo) {
        this.Modulo = Modulo;
    }

    public String getCambioRealizado() {
        return CambioRealizado;
    }

    public void setCambioRealizado(String CambioRealizado) {
        this.CambioRealizado = CambioRealizado;
    }

    public String getFechaCambio() {
        return FechaCambio;
    }

    public void setFechaCambio(String FechaCambio) {
        this.FechaCambio = FechaCambio;
    }

    public String getHoraCambio() {
        return HoraCambio;
    }

    public void setHoraCambio(String HoraCambio) {
        this.HoraCambio = HoraCambio;
    }
}
