/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosServicio;

import PageObjects.DatosServicio;
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
public class apellidoClienteTest {
    
    camposDebug obj_campoCedula;
    DatosServicio datosServ;

    public apellidoClienteTest() {
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
        obj_campoCedula = new camposDebug();

        boolean resultado = true;
        assertEquals(resultado, obj_campoCedula.espacioBlanco(cedula));
    }

    /**
     * no me puede ingresar numeros
     */
    @Test
    public void IngresarNumeros() {
        String nombre = "465787";
        obj_campoCedula = new camposDebug();

        boolean resultado = true;
        assertEquals(resultado, obj_campoCedula.es_numero(nombre));

    }

    @Test
    public void soloTexto() {
        String palabra = "hshsh7jj";
        obj_campoCedula = new camposDebug();

        boolean resultado = false;
        assertEquals(resultado, obj_campoCedula.SoloLetras(palabra.toCharArray(), 0));
    }

    /**
     * no ingresar caracteres extraños
     */
    @Test
    public void IngresarCarateresExtraños() {
        String apellido = "l@rgo ramirez";
        obj_campoCedula = new camposDebug();
        assertEquals(true, obj_campoCedula.caracteresRaros(apellido.toCharArray(),0));

    }

    /**
     * ingresar una cedula correcta esta se utilizará en una clase aparte para
     * integrarlo con los demas campos correctos se utilizará con selenium ya
     * que no existe un metodo para verificar que la cedula esté correcta
     */
    public void apellidoCorrecto(String apellido,WebDriver driver) {
        datosServ = new DatosServicio(driver);
        datosServ.SetApellido(apellido);
    }

}
