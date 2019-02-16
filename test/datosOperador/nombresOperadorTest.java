/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosOperador;

import POM.DatosOperador;
import com.credserv.utilidades.camposDebug;
import com.credserv.utilidades.placaDebug;
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
public class nombresOperadorTest {
    
    camposDebug obj_campoOperador;
    DatosOperador DatosPrecio;
    DatosOperador DatosOperador;

    public nombresOperadorTest() {
        
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
    public void nombre1_espacioBlanco() {
        String nombre1 = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(nombre1));
    }
    @Test
    public void nombre2_espacioBlanco() {
        String nombre2 = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(nombre2));
    }
    
    
    @Test
    public void nombre1_ingresarNumeros() {
        String nombre1 = "111111";
        obj_campoOperador = new camposDebug();      
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.es_numero(nombre1));      
    }
    @Test
    public void nombre2_ingresarNumeros() {
        String nombre2 = "222222";
        obj_campoOperador = new camposDebug();      
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.es_numero(nombre2));      
    }
    
    
    @Test
    public void nombre1_soloTexto() {
        String nombre1 = "sebas123";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.SoloLetras(nombre1.toCharArray(), 0));
    }
    
    @Test
    public void nombre2_soloTexto() {
        String nombre2 = "sebas123";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.SoloLetras(nombre2.toCharArray(), 0));
    }

    /**
     * no ingresar caracteres extraños
     */
    
    @Test
    public void nombre1_caracteresEspeciales() {
        obj_campoOperador = new camposDebug();
        String nombre1 = "dfsdfds/";
        boolean result = true;
        assertEquals(result, obj_campoOperador.caracteresRaros(nombre1.toCharArray(), 0));
    }
    
    @Test
    public void nombre2_caracteresEspeciales() {
        obj_campoOperador = new camposDebug();
        String nombre1 = "dfsdfds/";
        boolean result = true;
        assertEquals(result, obj_campoOperador.caracteresRaros(nombre1.toCharArray(), 0));
    }
    
     public void nombresCorrectos(WebDriver driver) {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.setNombres("Juan","Sebastian");
    }
    
    
    
}
