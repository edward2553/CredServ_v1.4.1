/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import prm_servicio.servicio_JUnit;
import PageObjects.Login;
import PageObjects.Servicios;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import prm_servicio.servicio_JUnit;

/**
 *
 * @author crist
 */
public class integracionServicio {

    private static WebDriver driver = null;
    Login log;
    Servicios servicios = new Servicios(driver);
    servicio_JUnit ServiciosDAO = new servicio_JUnit();

    public integracionServicio() {
    }

    @BeforeClass
    public static void setUpClass() {
        //se especifiica el tipo de driver y su ubicación
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //instanciamos el diver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //ponemos la pagina web
        driver.get("http://localhost:8084/CredServ_v1.4.1");
        // inicio de session
        log = new Login(driver);
        log.loginApplication("cristian_gomez23181@elpoli.edu.co", "cristiang");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void PruebaAutomatizadaInsertarServicio() {

        ServiciosDAO.TestAutomatizadaInsertarServicio(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void PruebaAutomatizadaEditarServicio() {

        ServiciosDAO.TestAutomatizadaEditarServicio(driver);

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void PruebaAutomatizadaEliminarServicio() {

        servicios.EliminarServicio();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

}
