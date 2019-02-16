/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosOperador;

import POM.DatosOperador;
import POM.DatosServicio;
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
public class apellidosOperadorTest {
    camposDebug obj_campoOperador;
    DatosOperador DatosOperador;

    public apellidosOperadorTest() {
        
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
    public void apellido1_espacioBlanco() {
        String apellido1 = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(apellido1));
    }
    @Test
    public void apellido2_espacioBlanco() {
        String apellido2 = "          ";
        obj_campoOperador = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.espacioBlanco(apellido2));
    }
    
    
    @Test
    public void apellido1_ingresarNumeros() {
        String apellido1 = "111111";
        obj_campoOperador = new camposDebug();      
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.es_numero(apellido1));      
    }
    @Test
    public void apellido2_ingresarNumeros() {
        String apellido2 = "222222";
        obj_campoOperador = new camposDebug();      
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.es_numero(apellido2));      
    }
    
    
    @Test
    public void apellido1_soloTexto() {
        String apellido1 = "sebas123";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.SoloLetras(apellido1.toCharArray(), 0));
    }
    
    @Test
    public void apellido2_soloTexto() {
        String apellido2 = "sebas123";
        obj_campoOperador = new camposDebug();
        boolean resultado = false;
        assertEquals(resultado, obj_campoOperador.SoloLetras(apellido2.toCharArray(), 0));
    }

    /**
     * no ingresar caracteres extraños
     */
    
    @Test
    public void apellido1_caracteresEspeciales() {
        obj_campoOperador = new camposDebug();
        String apellido1 = "dfsdfds/";
        boolean result = true;
        assertEquals(result, obj_campoOperador.caracteresRaros(apellido1.toCharArray(), 0));
    }
    
    @Test
    public void apellido2_caracteresEspeciales() {
        obj_campoOperador = new camposDebug();
        String apellido2 = "dfsdfds/";
        boolean result = true;
        assertEquals(result, obj_campoOperador.caracteresRaros(apellido2.toCharArray(), 0));
    }
    
    @Test
    public void apellido1_vacio() {
        String apellido1 = "";
        obj_campoOperador = new camposDebug();       
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.valorVacio(apellido1));
    }
    @Test
    public void apellido2_vacio() {
        String apellido2 = "";
        obj_campoOperador = new camposDebug();       
        boolean resultado = true;
        assertEquals(resultado, obj_campoOperador.valorVacio(apellido2));
    }
    
    
     public void apellidosCorrectos(WebDriver driver) {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.setApellidos("Arismendy","Buitrago");
    }
    
    
      
}
