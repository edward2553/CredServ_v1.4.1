/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosServicio;

import POM.DatosServicio;
import com.credserv.utilidades.camposDebug;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author edwar
 */
public class nombreClienteTest {
    
    camposDebug obj_campoCedula;
    DatosServicio datosServ;
    
    public nombreClienteTest() {
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
        String nombre = "          ";
        obj_campoCedula = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoCedula.espacioBlanco(nombre));
    }
    
    @Test
    public void IngresarNumeros() {
        String nombre = "46555";
        obj_campoCedula = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoCedula.es_numero(nombre));
        
    }
    
    @Test
    public void soloTexto() {
        String palabra = "sdsdsd555";
        obj_campoCedula = new camposDebug();
        
        boolean resultado = false;
        assertEquals(resultado, obj_campoCedula.SoloLetras(palabra.toCharArray(), 0));
    }

    /**
     * no ingresar caracteres extraños
     */
    @Test
    public void IngresarCarateresExtraños() {
        obj_campoCedula = new camposDebug();
        String nombre = "dfsdfds/";
        boolean result = true;
        assertEquals(result, obj_campoCedula.caracteresRaros(nombre.toCharArray(), 0));
    }

    /**
     * ingresar una cedula correcta esta se utilizará en una clase aparte para
     * integrarlo con los demas campos correctos se utilizará con selenium ya
     * que no existe un metodo para verificar que la cedula esté correcta
     */
    
    public void NombreCorrecto(String nombre,WebDriver driver) {
        
        datosServ = new DatosServicio(driver);
        datosServ.setNombre(nombre);
    }
    
}
