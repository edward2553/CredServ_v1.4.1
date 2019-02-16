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
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author sebastian.arismendy
 */
public class emailOperadorTest {
     camposDebug obj_campoOperador;
    DatosOperador DatosOperador;
    
    public emailOperadorTest() {
        
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

    
     public void emailCorrecto(WebDriver driver) {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.setEmail("sebax1502@gmail.com");
    }
}
