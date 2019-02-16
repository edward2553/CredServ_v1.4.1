/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import POM.Login;
import POM.Vehiculo;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import prm_vehiculo.vehiculos_JUnit;

/**
 *
 * @author crist
 */
public class integracionVehiculos {

    private static WebDriver driver = null;
    vehiculos_JUnit vehiculoDAO = new vehiculos_JUnit();
    Vehiculo vehiculo = new Vehiculo(driver);
    Login log;

    public integracionVehiculos() {
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
        driver.quit();
    }

    @Before
    public void setUp() {
        //ponemos la pagina web
        driver.get("http://localhost:8084/CredServ_v1.4.1/index.jsp");
        // inicio de session
        log = new Login(driver);
        log.loginApplication("cristian_gomez23181@elpoli.edu.co", "cristiang");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PruebaAutomatizadaInsertarVehiculo() {

        vehiculoDAO.TestAutomatizadaInsertarVehiculo(driver);

        Alert alert = driver.switchTo().alert();

        alert.accept();

    }

   @Test
    public void AutomatizadaEditarVehiculo() {

        vehiculoDAO.TestAutomatizadaEditarVehiculo(driver);
        Alert alert = driver.switchTo().alert();

        alert.accept();

    }

    @Test
    public void PruebaAutomatizadaEliminarVehiculo() {

        vehiculo.EliminarVehiculo();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
