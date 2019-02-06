/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_vehiculo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import prm_vehiculo.vehiculos_JUnit;

/**
 *
 * @author crist
 */
public class vehiculoIntegracion_JUnit {
    
    public vehiculoIntegracion_JUnit() {
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
    
        vehiculos_JUnit TestVehiculo = new vehiculos_JUnit();
    
        TestVehiculo.testExisteVehiculoMAYUS();
        TestVehiculo.testExisteVehiculoMINUS();
        TestVehiculo.testInsertarVehiculoCaractExtraños();
        TestVehiculo.testInsertarVehiculoEspaciosBlanco();
        TestVehiculo.testInsertarVehiculoNumeros();
        int id = TestVehiculo.testInsertarServicio();
        TestVehiculo.testEditarVehiculo(id);
        TestVehiculo.testEliminarVehiculo(id);
    
    }
    
}
