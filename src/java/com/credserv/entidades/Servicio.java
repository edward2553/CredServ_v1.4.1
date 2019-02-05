/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.entidades;

/**
 *
 * @author edward
 */
public class Servicio {

    private String cedula;
    private String placa_automotor;
    private int id_tipo_automotor;
    private int id_tipo_servicio;
    private String hora_entrada;
    private String hora_salida;
    private String fecha_entrada;
    private int ID_usuario;
    private double precio;
    private String durac_horas;
    private String durac_minutos;
    private double porc_descuento;
    private double total_descuento;
    private double valor_servicio_individual;
    private double total_sinDescuento;
    private String turno;

    public Servicio(String cedula, String placa_automotor, int id_tipo_automotor, int id_tipo_servicio, String hora_entrada, String hora_salida, String fecha_entrada, int ID_usuario, double precio, double porc_descuento, double total_descuento, double valor_individual, double total_sinDescuento, String turno, String durac_horas,String durac_minutos) {
        this.cedula = cedula;
        this.placa_automotor = placa_automotor;
        this.id_tipo_automotor = id_tipo_automotor;
        this.id_tipo_servicio = id_tipo_servicio;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.fecha_entrada = fecha_entrada;
        this.ID_usuario = ID_usuario;
        this.precio = precio;
        this.durac_horas = durac_horas;
        this.durac_minutos = durac_minutos;
        this.porc_descuento = porc_descuento;
        this.total_descuento = total_descuento;
        this.valor_servicio_individual = valor_individual;
        this.total_sinDescuento = total_sinDescuento;
        this.turno = turno;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the placa_automotor
     */
    public String getPlaca_automotor() {
        return placa_automotor;
    }

    /**
     * @param placa_automotor the placa_automotor to set
     */
    public void setPlaca_automotor(String placa_automotor) {
        this.placa_automotor = placa_automotor;
    }

    /**
     * @return the id_tipo_automotor
     */
    public int getId_tipo_automotor() {
        return id_tipo_automotor;
    }

    /**
     * @param id_tipo_automotor the id_tipo_automotor to set
     */
    public void setId_tipo_automotor(int id_tipo_automotor) {
        this.id_tipo_automotor = id_tipo_automotor;
    }

    /**
     * @return the id_tipo_servicio
     */
    public int getId_tipo_servicio() {
        return id_tipo_servicio;
    }

    /**
     * @param id_tipo_servicio the id_tipo_servicio to set
     */
    public void setId_tipo_servicio(int id_tipo_servicio) {
        this.id_tipo_servicio = id_tipo_servicio;
    }

    /**
     * @return the hora_entrada
     */
    public String getHora_entrada() {
        return hora_entrada;
    }

    /**
     * @param hora_entrada the hora_entrada to set
     */
    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    /**
     * @return the hora_salida
     */
    public String getHora_salida() {
        return hora_salida;
    }

    /**
     * @param hora_salida the hora_salida to set
     */
    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    /**
     * @return the fecha_entrada
     */
    public String getFecha_entrada() {
        return fecha_entrada;
    }

    /**
     * @param fecha_entrada the fecha_entrada to set
     */
    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    /**
     * @return the ID_usuario
     */
    public int getID_usuario() {
        return ID_usuario;
    }

    /**
     * @param ID_usuario the ID_usuario to set
     */
    public void setID_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPorc_descuento() {
        return porc_descuento;
    }

    public void setPorc_descuento(double porc_descuento) {
        this.porc_descuento = porc_descuento;
    }

    public double getTotal_descuento() {
        return total_descuento;
    }

    public void setTotal_descuento(double total_descuento) {
        this.total_descuento = total_descuento;
    }

    /**
     * @return the valor_servicio_individual
     */
    public double getValor_servicio_individual() {
        return valor_servicio_individual;
    }

    /**
     * @param valor_servicio_individual the valor_servicio_individual to set
     */
    public void setValor_servicio_individual(double valor_servicio_individual) {
        this.valor_servicio_individual = valor_servicio_individual;
    }

    /**
     * @return the total_sinDescuento
     */
    public double getTotal_sinDescuento() {
        return total_sinDescuento;
    }

    /**
     * @param total_sinDescuento the total_sinDescuento to set
     */
    public void setTotal_sinDescuento(double total_sinDescuento) {
        this.total_sinDescuento = total_sinDescuento;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }
    
        /**
     * @return the durac_horas
     */
    public String getDurac_horas() {
        return durac_horas;
    }

    /**
     * @param durac_horas the durac_horas to set
     */
    public void setDurac_horas(String durac_horas) {
        this.durac_horas = durac_horas;
    }

    /**
     * @return the durac_minutos
     */
    public String getDurac_minutos() {
        return durac_minutos;
    }

    /**
     * @param durac_minutos the durac_minutos to set
     */
    public void setDurac_minutos(String durac_minutos) {
        this.durac_minutos = durac_minutos;
    }



}
