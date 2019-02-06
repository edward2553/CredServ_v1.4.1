/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_Precio;

import com.credserv.entidades.EntidadServicio;
import com.credserv.entidades.EntidadServiciosServiteca;
import com.credserv.entidades.EntidadVehiculo;
import com.credserv.persistencia.ServiciosParametrizacionesDAO;
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
public class precio_JUnit {
    
    ServiciosParametrizacionesDAO dao = new ServiciosParametrizacionesDAO();
    
    public precio_JUnit() {
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
