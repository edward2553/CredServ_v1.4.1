/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import POM.Login;
import POM.Precio;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author crist
 */
public class IntegracionPrecio {

    private static WebDriver driver;
    Login log;
    Random i = new Random();
    String InputPrecioMenorACero = "-" + i.nextInt(998) + 1 + "";
    String PrecioLiAnInfe = "999";
    String PrecioLiDesSup = "2000001";
    String PrecioSele = "15000";
    String EditarPrecio = "50000";
    String PrecioCarExt = "*";
    Precio precio = new Precio(driver);

    public IntegracionPrecio() {
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
        driver.get("http://localhost:8084/CredServ_v1.4.1");
        // inicio de session
        log = new Login(driver);
        log.loginApplication("cristian_gomez23181@elpoli.edu.co", "cristiang");
    }

    @After
    public void tearDown() {

    }

    //Test de insertar precio = -500 o cualquier número negativo
    @Test
    public void InsertarPrecioMenorACero() {
        precio.IngresarPrecioMenorACero(InputPrecioMenorACero);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: No puede ingresar valores negativos";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de insertar precio 999, que seria el valor anterior al limite inferior
    //que es 1000
    @Test
    public void InsertarPrecioLimiteInferior() throws InterruptedException {
        Thread.sleep(1000);
        precio.IngresarPrecioMenorACero(PrecioLiAnInfe);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: Digitar un valor entre 1.000 y 2.000.000";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de insertar precio 2000001, que seria el valor después al limite superior
    //que es 1000
    @Test
    public void InsertarPrecioLimiteSuperior() throws InterruptedException {
        Thread.sleep(1000);
        precio.IngresarPrecioMenorACero(PrecioLiDesSup);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: Digitar un valor entre 1.000 y 2.000.000";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de insertar precio dejando los select en Elija un tipo de servicio
    @Test
    public void InsertarPrecioSinSelect() throws InterruptedException {
        Thread.sleep(1000);
        precio.IngresarPrecioSinSelect(PrecioSele);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: Recuerde elegir una opción de vehículos y servicio";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de insertar precio dejando los select en, elija un tipo de servicio
    @Test
    public void InsertarPrecioSelectServi() throws InterruptedException {
        Thread.sleep(1000);
        precio.IngresarPrecioSelecServicio(PrecioSele);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: Recuerde elegir una opción de vehículos y servicio";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de insertar precio dejando los select en, elija un tipo de servicio
    @Test
    public void InsertarPrecioSelectVehicu() throws InterruptedException {
        Thread.sleep(1000);
        precio.IngresarPrecioSelecVehiculo(PrecioSele);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: Recuerde elegir una opción de vehículos y servicio";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de editar precio 999, que seria el valor anterior al limite inferior
    //que es 1000
    @Test
    public void EditarPrecioLimiteInferior() throws InterruptedException {
        Thread.sleep(1000);
        precio.EditarPrecioLimiInfe(PrecioLiAnInfe);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: Digitar un valor entre 1.000 y 2.000.000";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de editar precio 999, que seria el valor depués al limite superior
    //que es 1000
    @Test
    public void EditarPrecioLimiteSuperior() throws InterruptedException {
        Thread.sleep(1000);
        precio.EditarPrecioLimiInfe(PrecioLiDesSup);

        Alert alert = driver.switchTo().alert();
        String resultado = alert.getText();

        String resultado2 = "Error: Digitar un valor entre 1.000 y 2.000.000";

        assertEquals(resultado, resultado2);

        alert.accept();
    }

    //Test de insertar precio 
    @Test
    public void PruebaInsertarPrecio() throws InterruptedException {
        Thread.sleep(1000);
        precio.IngresarPrecio(PrecioSele);

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    //Test de editar precio 
    @Test
    public void PruebaEditarPrecio() throws InterruptedException {

        precio.EditarPrecio(EditarPrecio);

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    //Test de editar precio 
    @Test
    public void PruebaEliminarPrecio() throws InterruptedException {
        Thread.sleep(1000);
        precio.EliminarPrecio();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
