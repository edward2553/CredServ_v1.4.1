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
public class telefonoOperadorTest {
     camposDebug obj_campoOperador;
    DatosOperador DatosOperador;
    
    public telefonoOperadorTest() {
        
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
        String telefono = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(telefono));
    }
    
    @Test
    public void vacio() {
        String telefono = "";
        obj_campoOperador = new camposDebug();       
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.valorVacio(telefono));
    }
    
    @Test
    public void  solo_numeros() {
        String telefono = "2a31721";
        obj_campoOperador = new camposDebug();

        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.es_numero(telefono));

    }
    
    @Test
    public void IngresarCarateresEspeciales() {
        String telefono = "56424*1";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        obj_campoOperador.caracteresRaros(telefono.toCharArray(), 0);     
        assertEquals(resultado, obj_campoOperador.es_numero(telefono));
    }
    
    @Test
    public void longitudTelefono() {
        String telefono = "5642421";
        obj_campoOperador = new camposDebug();
        boolean resultado = true;
        obj_campoOperador.caracteresRaros(telefono.toCharArray(), 0);     
        assertEquals(resultado, obj_campoOperador.es_numero(telefono));
    }
    
     public void telefonoCorrecto(WebDriver driver) {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.setTelefono("4526877");
    }
    
}
