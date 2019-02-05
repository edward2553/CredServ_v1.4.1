/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosServicio;

import PageObjects.DatosServicio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author edwar
 */
public class automotor_servicio {

    DatosServicio datosServ;

    public automotor_servicio() {
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
     * ingresar una cedula correcta esta se utilizará en una clase aparte para
     * integrarlo con los demas campos correctos se utilizará con selenium ya
     * que no existe un metodo para verificar que la cedula esté correcta
     */
    public void clickAutotmotorServicio(WebDriver driver) {
        datosServ = new DatosServicio(driver);
        datosServ.click_automotorYservicio();
    }

}
