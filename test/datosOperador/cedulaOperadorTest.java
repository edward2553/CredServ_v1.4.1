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
public class cedulaOperadorTest {
    
    camposDebug obj_campoOperador;
    DatosOperador DatosOperador;
    
    public cedulaOperadorTest() {
        
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
        String cedula = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(cedula));
    }

    /**
     * recordar que siempre deben haber minimo 10 numeros en campo cedula
     */
    @Test
    public void minimoNumerosPocibles() {
        String cedula = "1000754923";
        obj_campoOperador = new camposDebug();
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.longitud_campoCedula(cedula));
    }

    /**
     * false si no es un numero
     */
    @Test
    public void  solo_numeros() {
        String cedula = "abc123456789";
        obj_campoOperador = new camposDebug();

        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.es_numero(cedula));

    }

    /**
     * no ingresar caracteres extraños
     */
    
    @Test
    public void IngresarCarateresEspeciales() {
        String cedula = "10007%4923";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        obj_campoOperador.caracteresRaros(cedula.toCharArray(), 0);     
        assertEquals(resultado, obj_campoOperador.es_numero(cedula));
    }
    @Test
    public void vacio() {
        String cedula = "";
        obj_campoOperador = new camposDebug();       
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.valorVacio(cedula));
    }
    
    public void cedulaCorrecto(WebDriver driver) {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.setCedula("1000754923");
    }
}
