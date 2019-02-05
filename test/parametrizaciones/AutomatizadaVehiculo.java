/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrizaciones;

import PageObjects.Login;
import PageObjects.Vehiculo;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author crist
 */
public class AutomatizadaVehiculo {

    private static WebDriver driver = null;
    VehiculoParametrizacionesDAOTest vehiculoDAO = new VehiculoParametrizacionesDAOTest();
    Vehiculo vehiculo = new Vehiculo(driver);
    Login log;

    public AutomatizadaVehiculo() {
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
        driver.get("http://localhost:8084/CredServ_v1.4/index.jsp");
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
    public void PruebaAutomatizadaEliminarServicio() {

        vehiculo.EliminarVehiculo();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
