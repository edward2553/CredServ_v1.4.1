/*
 IMPORTANTE
en esta clase se integran los casos de prueba de la clase servicio_JUnit 
 */
package prm_servicio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import prm_servicio.servicio_JUnit;
import static org.junit.Assert.*;

/**
 *
 * @author crist
 */
public class servicioIntegracion_JUnit {

    public servicioIntegracion_JUnit() {
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
    public void ServcioTest() {
        
        servicio_JUnit ServicioTest = new servicio_JUnit();
        
        ServicioTest.testExisteServicioMAYUS();
        ServicioTest.testExisteServicioMinuscula();
        ServicioTest.testInsertarServicioCaractExtraños();
        ServicioTest.testInsertarServicioEspaciosBlanco();
        ServicioTest.testInsertarServicioNumeros();
        int id = ServicioTest.testInsertarServicio();
        ServicioTest.testEditarServicio(id);
        ServicioTest.testEliminarServicios(id);

    }
}
