/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosOperador;

import POM.DatosOperador;
import com.credserv.utilidades.camposDebug;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author sebastian.arismendy
 */
public class contraseñaOperadorTest {
    camposDebug obj_campoOperador;
    DatosOperador DatosOperador;
    
    public contraseñaOperadorTest() {
        
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
     * Test of campo_espacioEnBlanco method, of class
     * camposIngresarServicioDebug.
     */
    
    @Test
    public void Espacios_Blanco() {
        String contraseña = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(contraseña));
    }
    
    @Test
    public void vacio() {
        String contraseña = "";
        obj_campoOperador = new camposDebug();       
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.valorVacio(contraseña));
    }
    
    public void contraseñaCorrecto(WebDriver driver) {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.setContraseña("1234567S");
    }
    
}
