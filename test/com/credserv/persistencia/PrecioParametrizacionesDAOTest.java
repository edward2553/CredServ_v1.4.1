/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import com.credserv.entidades.EntidadServicio;
import com.credserv.entidades.EntidadServiciosServiteca;
import com.credserv.entidades.EntidadVehiculo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author crist
 */
public class PrecioParametrizacionesDAOTest {
    
    ServiciosParametrizacionesDAO dao = new ServiciosParametrizacionesDAO();
    
    public PrecioParametrizacionesDAOTest() {
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


    /**
     * Test of existeServicioServiteca method
     */
    @Test
    public void testExisteServicioServiteca() {
        System.out.println("existeServicioServiteca");
        int IDServico = 1;
        int IDVehiculo = 1;
        boolean validar = dao.existeServicioServiteca(IDServico, IDVehiculo);
        boolean expResult = true;
        assertEquals(expResult, validar);
    }

    
    
}
