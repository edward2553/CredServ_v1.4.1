/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public Conexion() {
        con = null;
    }

    Connection con;
    protected Statement stm;

    public Connection obtenerConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "CREDSERV", "CREDSERV");
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" el error es " + e.getMessage() + " por causa de " + e.getCause());
        }
        return con;
    }
    
    public Statement getStamenet(){
        return this.stm;
    }
    
    public void desconectar(){
        try {
            con.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("error al desconectar");
        }
    }

    public static void main(String[] args) {
         Conexion con= new Conexion();

        try {
            ResultSet rs = con.obtenerConexion().prepareStatement("select * from USUARIO").executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
            }

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
