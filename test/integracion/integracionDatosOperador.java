package integracion;


import POM.DatosOperador;
import datosOperador.apellidosOperadorTest;
import datosOperador.cedulaOperadorTest;
import datosOperador.contraseñaOperadorTest;
import datosOperador.direccionOperadorTest;
import datosOperador.edadOperadorTest;
import datosOperador.emailOperadorTest;
import datosOperador.nombresOperadorTest;
import datosOperador.telefonoOperadorTest;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastian.arismendy
 */
public class integracionDatosOperador {
    
    private static WebDriver driver= null;
    POM.Login log;
    nombresOperadorTest obj_nombres;
    apellidosOperadorTest obj_apellidos;
    cedulaOperadorTest obj_cedula;
    edadOperadorTest obj_edad;
    emailOperadorTest obj_email;
    contraseñaOperadorTest obj_contraseña;
    telefonoOperadorTest obj_telefono;
    direccionOperadorTest obj_direccion;
    DatosOperador DatosOperador;
    
    
    public integracionDatosOperador() {

    }
    
    public static void pausa(long sleeptime) {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException ex) {
           
        }
    }

    @BeforeClass
    public static void setUpClass() {
        //se especifiica el tipo de driver y su ubicación
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe ");
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
        log = new POM.Login(driver);
        log.loginApplication(email, password);
        
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void Integracion() {
        DatosOperador = new DatosOperador(driver);
        DatosOperador.clickParametrizarOperadores();
        pausa(500);
        DatosOperador.clickAgregarOperador();
        pausa(2000);
        DatosOperador.setNombres("Juan","Sebastian");
        pausa(500);
        DatosOperador.setApellidos("Arismendy","Buitrago");
        pausa(500);
        DatosOperador.setCedula("1000754923");
        pausa(500);
        DatosOperador.setEdad("18");
        pausa(500);
        DatosOperador.setEmail("sebax1502@gmail.com");
        pausa(500);
        DatosOperador.setContraseña("1234567S");
        pausa(500);
        DatosOperador.setTelefono("4526877");
        pausa(500);
        DatosOperador.setDirreción("cll 85 A # 51 B 58");
        pausa(500);
        DatosOperador.clickAgregar();
        pausa(500);
        Alert alertAccount = driver.switchTo().alert();
        alertAccount.accept();
        pausa(3000);
        DatosOperador.clickEliminar();
    }

}
