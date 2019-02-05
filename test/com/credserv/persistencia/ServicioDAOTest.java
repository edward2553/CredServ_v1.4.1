/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;


import com.credserv.entidades.Servicio;
import java.util.Random;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author edwar
 */
public class ServicioDAOTest {

    public ServicioDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {        
    }

    @After
    public void tearDown() {
    }

    Random i = new Random();
    /**
     * Test of insertarServicio method, of class ServicioDAO.
     * TRUE si inserta el servicio correctamente
     * FALSE si no inserta el servicio correctamente
     * 
     * nota: se verifica si el cliente existe en un servlet con los metodos que hay en ClienteDAO
     */
    @Test
    public void testInsertarServicio() {
//        System.out.println("insertarServicio");
//        String turnoAleatorio = UUID.randomUUID().toString().toUpperCase().substring(0, 4);
//        Servicio serv = new Servicio("", "", 0, 0, "","", 0, 0, "", 0, 0, 0, 0,"");
//        ServicioDAO instance = new ServicioDAO();
//        boolean expResult = true;
//        boolean result = instance.insertarServicio(serv);
//        assertEquals(expResult, result);

    }

}
