/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosServicio;

import PageObjects.DatosServicio;
import PageObjects.Login;
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
public class CedulaTest {

    camposDebug obj_campoCedula;
    Login log;
    DatosServicio datosServ;

    public CedulaTest() {
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
     * recordar que siempre deben haber minimo 10 numeros en campo cedula
     */
    @Test
    public void minimoNumerosPocibles() {
        String cedula = "1007015406";
        obj_campoCedula = new camposDebug();

        boolean resultado = true;
        assertEquals(resultado, obj_campoCedula.longitud_campoCedula(cedula));
    }

    /**
     * false si no es un numero
     */
    @Test
    public void  solo_numeros() {
        String cedula = "abc123456789";
        obj_campoCedula = new camposDebug();

        boolean resultado = false;
        assertEquals(resultado, obj_campoCedula.es_numero(cedula));

    }

    /**
     * no ingresar caracteres extraños
     */
    @Test
    public void IngresarCarateresExtraños() {
        String cedulaVector = "10080%2609";
        obj_campoCedula = new camposDebug();
        
        assertEquals(true,obj_campoCedula.caracteresRaros(cedulaVector.toCharArray(), 0));
        

    }

    /**
     * ingresar una cedula correcta esta se utilizará en una clase aparte para
     * integrarlo con los demas campos correctos se utilizará con selenium ya
     * que no existe un metodo para verificar que la cedula esté correcta
     */
    
    public void cedulaCorrecta(String cedula,WebDriver driver) {

        datosServ = new DatosServicio(driver);
        datosServ.SetCedula(cedula);
    }

}
