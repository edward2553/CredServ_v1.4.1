/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosServicio;

import POM.DatosServicio;
import com.credserv.utilidades.camposDebug;
import com.credserv.utilidades.placaDebug;
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
public class placaClienteTest {
    
    camposDebug obj_camposDebug;
    placaDebug obj_Placa;

    public placaClienteTest() {
        
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
        String placa = "          ";
        obj_camposDebug = new camposDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_camposDebug.espacioBlanco(placa));
    }
    
    @Test
    public void LongitudPLaca() {
        String placa = "bdg-8";
        obj_Placa = new placaDebug();
        
        boolean resultado = true;
        assertEquals(resultado, obj_Placa.longitudPlaca(placa));
    }
    

    /**
     * no ingresar caracteres extraños
     */
    @Test
    public void IngresarCarateresExtraños() {
        obj_camposDebug = new camposDebug();
        String nombre = "rdf_556";
        boolean result = true;
        assertEquals(result, obj_camposDebug.caracteresRaros(nombre.toCharArray(), 0));
    }
    
    /**
     * numeros
     */
    @Test
    public void tresNumeros(){
    
        String placa = "abc-123";
        obj_Placa = new placaDebug();
        boolean expected = obj_Placa.esNumero(placa.substring(4));
        boolean resultado = true;
        assertEquals(resultado,expected);
    }
    @Test
    public void tresLetras(){
    
        String placa = "adf-889";
        obj_Placa = new placaDebug();
        boolean expected = obj_Placa.letras(placa.substring(0, 4).toCharArray(), 0);
        boolean resultado = true;
        assertEquals(resultado,expected);
    }
    
    /**
     * chequeando que si tenga el gion
     */
    @Test
    public void gion(){
        
        String placa = "adf-567";
        boolean resultado = true;
         boolean expected;
         String guion = placa.substring(3, 4);
        if (guion.equalsIgnoreCase("-")) {
           expected = true;
        }else{
           expected = false;
        }
        assertEquals(resultado,expected);
        
    
    }

    /**
     * ingresar una cedula correcta esta se utilizará en una clase aparte para
     * integrarlo con los demas campos correctos se utilizará con selenium ya
     * que no existe un metodo para verificar que la cedula esté correcta
     */
    
    public void placaCorrecta(String placa,WebDriver driver) {
        
        DatosServicio datosServ = new DatosServicio(driver);
        datosServ.setPlaca(placa);
    }
    
}
