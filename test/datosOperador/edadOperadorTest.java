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
public class edadOperadorTest {
     camposDebug obj_campoOperador;
    DatosOperador DatosOperador;
    
    public edadOperadorTest() {
        
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
        String edad = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(edad));
    }
    
    @Test
    public void  solo_numeros() {
        String edad = "a1";
        obj_campoOperador = new camposDebug();

        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.es_numero(edad));

    }
    
    @Test
    public void negativos() {
        String edad = "-1";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.negativos(edad));
    }
    
    @Test
    public void IngresarCarateresEspeciales() {
        String edad = "18*";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        obj_campoOperador.caracteresRaros(edad.toCharArray(), 0);     
        assertEquals(resultado, obj_campoOperador.es_numero(edad));
    }
    
    @Test
    public void limite() {
        String edad = "99";
        obj_campoOperador = new camposDebug();
        boolean resultado = true;
        obj_campoOperador.longitud_edad(edad);     
        assertEquals(resultado, obj_campoOperador.es_numero(edad));
    }
    
    @Test
    public void vacio() {
        String edad = "";
        obj_campoOperador = new camposDebug();       
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.valorVacio(edad));
    }
    
    public void edadCorrecto(WebDriver driver) {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.setEdad("18");
    }
    
}
