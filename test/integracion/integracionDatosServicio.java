package integracion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PageObjects.CosteoYfacturacion;
import PageObjects.DatosServicio;
import PageObjects.Login;
import datosServicio.CedulaTest;
import datosServicio.apellidoClienteTest;
import datosServicio.automotor_servicio;
import datosServicio.horasCampo;
import datosServicio.nombreClienteTest;
import datosServicio.placaClienteTest;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author edwar
 */
public class integracionDatosServicio {

    CedulaTest obj_cedula;
    apellidoClienteTest obj_apellido;
    nombreClienteTest obj_nombre;
    placaClienteTest obj_placa;
    horasCampo horas;
    CosteoYfacturacion obj_CosteoYfacturacion;
    automotor_servicio obj_aut_serv;
    private static WebDriver driver = null;
    Login log;
    DatosServicio obj_datos;

    public integracionDatosServicio() {

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
        driver.get("http://localhost:8084/CredServ_v1.4.1/index.jsp");
        // inicio de session
        String email = "cristian_gomez23181@elpoli.edu.co";
        String password = "cristiang";
        log = new Login(driver);
        log.loginApplication(email, password);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of campo_espacioEnBlanco method, of class
     * camposIngresarServicioDebug.
     */
    @Test
    public void Integracion() throws InterruptedException {

        String cedula = "1007015406";
        String nombre = "edward andres";
        String apellido = "moron quintana";
        String placa = "erg-456";
        String hora = "0233p";

        obj_cedula = new CedulaTest();
        obj_nombre = new nombreClienteTest();
        obj_apellido = new apellidoClienteTest();
        obj_placa = new placaClienteTest();
        horas = new horasCampo();
        obj_aut_serv = new automotor_servicio();
        obj_datos = new DatosServicio(driver);
        obj_CosteoYfacturacion = new CosteoYfacturacion(driver);

        String pepe = obj_datos.getTurno();
        obj_cedula.cedulaCorrecta(cedula, driver);
        obj_nombre.NombreCorrecto(nombre, driver);
        obj_apellido.apellidoCorrecto(apellido, driver);
        obj_placa.placaCorrecta(placa, driver);
        obj_aut_serv.clickAutotmotorServicio(driver);
        horas.horaSlida(hora, driver);
        obj_datos.clickBtn_continuar( );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        obj_CosteoYfacturacion.esperarporAlerta(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        boolean resultado2 = obj_CosteoYfacturacion.verificarDatos(pepe); 

        boolean resultado = true;
        
         assertEquals(resultado,resultado2);

    }

}
