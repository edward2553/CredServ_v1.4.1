/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author crist
 */
public class VehiculoJUnitTest {
    
    public VehiculoJUnitTest() {
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

    
    @Test
    public void TestVehiculo(){
    
        VehiculoParametrizacionesDAOTest TestVehiculo = new VehiculoParametrizacionesDAOTest();
    
        TestVehiculo.testExisteServicioMAYUS();
        TestVehiculo.testExisteServicioMINUS();
        TestVehiculo.testInsertarVehiculoCaractExtraños();
        TestVehiculo.testInsertarVehiculoEspaciosBlanco();
        TestVehiculo.testInsertarVehiculoNumeros();
        int id = TestVehiculo.testInsertarServicio();
        TestVehiculo.testEditarVehiculo(id);
        TestVehiculo.testEliminarVehiculo(id);
    
    }
    
}
